package am.armhistory.dac.impl;

import am.armhistory.dac.ArmHistoryDao;
import am.armhistory.dac.DAOFactory;
import am.armhistory.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ArmHistoryDaoImpl implements ArmHistoryDao {

	private DAOFactory daoFactory;
	private DriverManagerDataSource driverManagerDataSource;
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public ArmHistoryDaoImpl(DAOFactory daoFactory, DriverManagerDataSource driverManagerDataSource) {
		this.daoFactory = daoFactory;
		this.driverManagerDataSource = driverManagerDataSource;
	}

	@Override
	public Collection<Subject> loadSubjects(){
		String sql = daoFactory.getQuery("loadSubjects");
		return daoFactory.getReadJdbcTemplate().query(sql, new DaoHelper.SubjectMapper());
	}

	@Override
	public Collection<Book> loadBooksBySubjectId(Integer subjectId) {
		String sql = daoFactory.getQuery("loadBooksBySubjectId");
		SqlParameterSource namedParameters = new MapSqlParameterSource("subjectId", subjectId);
		return daoFactory.getReadJdbcTemplate().query(sql,namedParameters, new DaoHelper.BookMapper());
	}


	@Override
	public Collection<Part> loadPartsByBookId(Integer bookId) {
		String sql = daoFactory.getQuery("loadPartsByBookId");
		SqlParameterSource namedParameters = new MapSqlParameterSource("bookId", bookId);
		return daoFactory.getReadJdbcTemplate().query(sql,namedParameters, new DaoHelper.PartMapper());
	}

	@Override
	public Collection<Header> loadHeadersBySubjectId(Integer subjectId){
		String sql = daoFactory.getQuery("loadHeadersBySubjectId");
		SqlParameterSource namedParameters = new MapSqlParameterSource("subjectId", subjectId);
		return daoFactory.getReadJdbcTemplate().query(sql, namedParameters, new DaoHelper.HeaderMapper());
	}

	@Override
	public Collection<Question> loadQuestions() {
		String sql = daoFactory.getQuery("loadQuestions");
		Collection<Question> questions;
		DaoHelper.QuestionMapper questionMapper  = new DaoHelper.QuestionMapper();
		DaoHelper.AnswerMapper answerMapper  = new DaoHelper.AnswerMapper();
		try {
			questions = daoFactory.getReadJdbcTemplate().query(sql,
					rs -> {
                        Map<Integer, Question> questionMap = new HashMap<>();
                        while (rs.next()) {
                            Integer questionId = rs.getInt("id");
                            Question question = questionMap.get(questionId);
                            if (question == null) {
                                question = questionMapper.mapRow(rs, 0);
								questionMap.put(questionId, question);
                            }
                            Answer answer = answerMapper.mapRow(rs, 0);
                            question.getAnswers().add(answer);
                        }
                        return questionMap.values();
                    });
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return questions;
	}

/*	public void insertQuestions(Collection<Question> questions){
		NamedParameterJdbcTemplate jdbcTemplate = daoFactory.getWriteJdbcTemplate();
		String sql = daoFactory.getQuery("insertQuestions");
		List<SqlParameterSource> parameters = questions.stream().map(BeanPropertySqlParameterSource::new).collect(Collectors.toList());
		jdbcTemplate.batchUpdate(sql, parameters.toArray(new SqlParameterSource[0]));
		// inserting answers
		List<Answer> answers = new ArrayList<>();
		questions.forEach((q)->answers.addAll(q.getAnswers()));
		insertAnswers(answers);
	}*/

	public void insertAnswers(Collection<Answer> answers){
		NamedParameterJdbcTemplate jdbcTemplate = daoFactory.getWriteJdbcTemplate();
		String sql = daoFactory.getQuery("insertAnswers");
		List<SqlParameterSource> parameters = answers.stream().map(BeanPropertySqlParameterSource::new).collect(Collectors.toList());
		jdbcTemplate.batchUpdate(sql, parameters.toArray(new SqlParameterSource[0]));
	}


	@Override
	public void insertQuestions(Collection<Question> questions){
		String sql = daoFactory.getQuery("insertQuestions");
		PreparedStatement insertBatch = null;
		try {
			insertBatch = driverManagerDataSource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (Question question : questions) {
				insertBatch.setString(1, question.getQuestion());
				insertBatch.setInt(2, question.getType());
				insertBatch.addBatch();
			}
			insertBatch.executeBatch();
			ResultSet generatedKeys = insertBatch.getGeneratedKeys();

			for (Question question : questions) {
				if ( generatedKeys == null || ! generatedKeys.next()){
					logger.warn("Unable to retrieve all generated keys");
				}
				question.setId(generatedKeys != null ? generatedKeys.getInt("id") : null);
			}
			logger.debug("questions inserted");
			List<Answer> answers = new ArrayList<>();
			questions.forEach((q)->q.getAnswers().forEach(a -> a.setQuestionId(q.getId())));
			questions.forEach((q)->answers.addAll(q.getAnswers()));
			insertAnswers(answers);
			logger.debug("answers inserted");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}


}
