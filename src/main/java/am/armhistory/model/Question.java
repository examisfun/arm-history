package am.armhistory.model;


import java.util.ArrayList;
import java.util.List;

public class Question {
	private Integer id;
	private String question;
	private Integer type;
	private List<Answer> answers = new ArrayList<>();

	public Question(Integer id, String question, Integer type) {
		this.id = id;
		this.question = question;
		this.type = type;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
