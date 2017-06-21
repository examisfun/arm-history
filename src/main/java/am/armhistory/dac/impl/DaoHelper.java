package am.armhistory.dac.impl;

import am.armhistory.dac.helper.FieldsJsonConverter;
import am.armhistory.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

final class DaoHelper {

	static class SubjectMapper
			implements RowMapper<Subject> {
		@Override
		public Subject mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new Subject(rs.getInt("subjectId"), rs.getString("name"));
		}
	}

	static class BookMapper
			implements RowMapper<Book> {
		@Override
		public Book mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new Book(rs.getInt("bookId"), rs.getString("name"));
		}
	}

	static class PartMapper
			implements RowMapper<Part> {
		@Override
		public Part mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new Part(rs.getInt("partId"), rs.getString("name"));
		}
	}

	static class HeaderMapper
			implements RowMapper<Header> {
		@Override
		public Header mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new Header(rs.getInt("headerId"), rs.getString("name"));
		}
	}

	static class QuestionMapper
			implements RowMapper<Question> {
		@Override
		public Question mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Question question = new Question();
			question.setQuestionId(rs.getInt("questionId"));
			question.setBookId(rs.getInt("bookId"));
			question.setPartId(rs.getInt("partId"));
			question.setHeaderId(rs.getInt("headerId"));
			question.setQuestionNumber(rs.getInt("questionNumber"));
			question.setType(rs.getInt("type"));
			FieldsJsonConverter converter = new FieldsJsonConverter();
			try {
				question.setQuestion(converter.convertToEntityAttribute(rs.getObject("question")));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return question;
		}
	}

	static class AnswerMapper
			implements RowMapper<Answer> {
		@Override
		public Answer mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new Answer(rs.getInt("answerId"), rs.getInt("id"), rs.getString("answer"), rs.getInt("option"), rs.getBoolean("isTrueAnswer"));
		}
	}
	
}
