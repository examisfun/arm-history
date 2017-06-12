package am.armhistory.endpoint;

import am.armhistory.model.Header;
import am.armhistory.model.Question;
import am.armhistory.model.QuestionDto;
import am.armhistory.model.Subject;
import am.armhistory.service.ArmHistoryInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
	public Collection<Question> getQuestions() {
		return armHistoryInternalService.loadQuestions();
	}

	@RequestMapping(value = "/getSubjects", method = RequestMethod.GET)
	public Collection<Subject> getSubjects() {
		return armHistoryInternalService.loadSubjects();
	}

	@RequestMapping(value = "/getHeaders", method = RequestMethod.GET)
	public Collection<Header> getHeader(@RequestParam Integer subjectId) {
		return armHistoryInternalService.loadHeadersBySubjectId(subjectId);
	}

	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	public void saveQuestions(@RequestBody QuestionDto questionDto) {
		armHistoryInternalService.saveQuestions(questionDto);
	}

}
