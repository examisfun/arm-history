package am.armhistory.dac.impl;

import am.armhistory.model.Answer;
import am.armhistory.model.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

final class DaoHelper {

	static class QuestionMapper
			implements RowMapper<Question> {
		@Override
		public Question mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new Question(rs.getInt("id"), rs.getString("question"), rs.getInt("type"));
		}
	}

	static class AnswerMapper
			implements RowMapper<Answer> {
		@Override
		public Answer mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new Answer(rs.getInt("answerId"), rs.getString("answer"), rs.getInt("option"), rs.getBoolean("isTrueAnswer"));
		}
	}
	
}
