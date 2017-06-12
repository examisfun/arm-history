package am.armhistory.service.impl;

import am.armhistory.dac.ArmHistoryDao;
import am.armhistory.model.*;
import am.armhistory.service.ArmHistoryInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public class ArmHistoryInternalServiceImpl implements ArmHistoryInternalService {

	private final ArmHistoryDao armHistoryDao;

	@Autowired
	public ArmHistoryInternalServiceImpl(ArmHistoryDao armHistoryDao) {
		this.armHistoryDao = armHistoryDao;
	}

	@Override
	public Collection<Subject> loadSubjects() {
		return armHistoryDao.loadSubjects();
	}

	@Override
	public Collection<Book> loadBooksBySubjectId(Integer subjectId) {
		return armHistoryDao.loadBooksBySubjectId(subjectId);
	}

	@Override
	public Collection<Part> loadPartsByBookId(Integer bookId) {
		return armHistoryDao.loadPartsByBookId(bookId);
	}

	@Override
	public Collection<Question> loadQuestions() {
		return armHistoryDao.loadQuestions();
	}

	@Override
	public Collection<Header> loadHeadersBySubjectId(Integer subjectId) {
		return armHistoryDao.loadHeadersBySubjectId(subjectId);
	}

	public void saveQuestions(QuestionDto questionDto){
		List<Question> questions = new ArrayList<>();
		Question question = new Question(questionDto.id, questionDto.question, 1);
		Map<Integer, String> answerMap = questionDto.answers;
		List<Answer> answers = new ArrayList<>();
		for(Integer option :answerMap.keySet()){
			Answer answer = new Answer();
			answer.setAnswer(answerMap.get(option));
			answer.setOption(option);
			answer.setTrueAnswer(questionDto.rightAnswer.equals(option));
			answers.add(answer);
		}
		question.setAnswers(answers);
		questions.add(question);
		armHistoryDao.insertQuestions(questions);
	}

}
