package am.armhistory.endpoint;

import am.armhistory.service.ArmHistoryInternalService;
import am.armhistory.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/armhistory")
public class ArmHistoryServiceController {

	private final ArmHistoryInternalService armHistoryInternalService;


	@Autowired
	public ArmHistoryServiceController(ArmHistoryInternalService armHistoryService) {
		this.armHistoryInternalService = armHistoryService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Set<Question> getQuestions() {
		return armHistoryInternalService.getQuestions();
	}

}
