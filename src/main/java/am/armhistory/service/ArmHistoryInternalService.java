package am.armhistory.service;

import am.armhistory.model.Question;
import am.armhistory.model.QuestionDto;

import java.util.Collection;

public interface ArmHistoryInternalService {

	Collection<Question> loadQuestions();
	void saveQuestions(QuestionDto questionDto);

}
