package am.armhistory.dac.impl;

import am.armhistory.dac.DAOFactory;
import com.google.common.collect.Sets;
import am.armhistory.dac.ArmHistoryDao;
import am.armhistory.model.Question;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class ArmHistoryDaoImpl
		implements ArmHistoryDao {

	private DAOFactory daoFactory;
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public ArmHistoryDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public Set<Question> getQuestions() {
		String sql = daoFactory.getQuery("loadQuestions");
		List<Question> questions;
		try {
			questions = daoFactory.getReadJdbcTemplate().query(sql,
					new DaoHelper.QuestionMapper());
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}

		return Sets.newHashSet(questions);
	}
}
