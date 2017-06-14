package am.armhistory.dac;

import am.armhistory.model.*;

import java.util.Collection;

public interface ArmHistoryDao {
	Collection<Subject> loadSubjects();
	Collection<Book> loadBooksBySubjectId(Integer subjectId);
	Collection<Part> loadPartsByBookId(Integer bookId);
	Collection<Header> loadHeadersByPartId(Integer partId);
	Collection<Question> loadQuestions();
	void insertQuestions(Collection<Question> questions);
}
