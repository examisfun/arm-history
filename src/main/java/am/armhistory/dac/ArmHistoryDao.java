package am.armhistory.dac;

import am.armhistory.model.Question;

import java.util.Collection;

public interface ArmHistoryDao {
	Collection<Question> loadQuestions();
	void insertQuestions(Collection<Question> questions);
}
