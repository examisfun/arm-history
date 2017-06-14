package am.armhistory.endpoint;

import am.armhistory.model.*;
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

	@RequestMapping(value = "/getBooks", method = RequestMethod.GET)
	public Collection<Book> getBooksBySubjectId(@RequestParam Integer subjectId) {
		return armHistoryInternalService.loadBooksBySubjectId(subjectId);
	}

	@RequestMapping(value = "/getParts", method = RequestMethod.GET)
	public Collection<Part> getPartsByBookId(@RequestParam Integer bookId) {
		return armHistoryInternalService.loadPartsByBookId(bookId);
	}

	@RequestMapping(value = "/getHeaders", method = RequestMethod.GET)
	public Collection<Header> getHeadersByPartId(@RequestParam Integer partId) {
		return armHistoryInternalService.loadHeadersBySubjectId(partId);
	}

	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	public void saveQuestions(@RequestBody QuestionDto questionDto) {
		armHistoryInternalService.saveQuestions(questionDto);
	}

}
