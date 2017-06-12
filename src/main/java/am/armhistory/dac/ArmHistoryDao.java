package am.armhistory.dac;

import am.armhistory.model.Header;
import am.armhistory.model.Question;
import am.armhistory.model.Subject;

import java.util.Collection;

public interface ArmHistoryDao {
	Collection<Question> loadQuestions();
	Collection<Subject> loadSubjects();
	Collection<Header> loadHeadersBySubjectId(Integer subjectId);
	void insertQuestions(Collection<Question> questions);
}
