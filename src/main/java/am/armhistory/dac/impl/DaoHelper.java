package am.armhistory.dac.impl;

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
}
