package am.armhistory.service.impl;

import am.armhistory.service.ArmHistoryInternalService;
import am.armhistory.dac.ArmHistoryDao;
import am.armhistory.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ArmHistoryInternalServiceImpl implements ArmHistoryInternalService {

	private final ArmHistoryDao armHistoryDao;

	@Autowired
	public ArmHistoryInternalServiceImpl(ArmHistoryDao armHistoryDao) {
		this.armHistoryDao = armHistoryDao;
	}

	public Set<Question> getQuestions() {
		return armHistoryDao.getQuestions();
	}
}
