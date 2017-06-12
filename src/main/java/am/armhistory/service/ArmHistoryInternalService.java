package am.armhistory.service;

import am.armhistory.model.Header;
import am.armhistory.model.Question;
import am.armhistory.model.QuestionDto;
import am.armhistory.model.Subject;

import java.util.Collection;

public interface ArmHistoryInternalService {

	Collection<Question> loadQuestions();
	Collection<Subject> loadSubjects();
	Collection<Header> loadHeadersBySubjectId(Integer subjectId);
	void saveQuestions(QuestionDto questionDto);

}
