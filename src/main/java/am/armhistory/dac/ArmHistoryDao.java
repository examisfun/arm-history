package am.armhistory.dac;

import am.armhistory.model.Question;

import java.util.Set;

public interface ArmHistoryDao {
	Set<Question> getQuestions();
}
