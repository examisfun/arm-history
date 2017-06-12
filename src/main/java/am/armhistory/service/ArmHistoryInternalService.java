package am.armhistory.service;

import am.armhistory.model.*;

import java.util.Collection;

public interface ArmHistoryInternalService {

	Collection<Subject> loadSubjects();
	Collection<Book> loadBooksBySubjectId(Integer subjectId);
	Collection<Part> loadPartsByBookId(Integer bookId);
	Collection<Header> loadHeadersBySubjectId(Integer subjectId);
	Collection<Question> loadQuestions();
	void saveQuestions(QuestionDto questionDto);

}
