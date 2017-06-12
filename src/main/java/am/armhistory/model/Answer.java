package am.armhistory.model;

/**
 * Created by Gevorg Minasyan on 6/10/2017.
 */
public class Answer {

    private Integer id;
    private Integer questionId;
    private String answer;
    private Integer option;
    private Boolean isTrueAnswer;

    public Answer() {
    }

    public Answer(Integer id, Integer questionId, String answer, Integer option, Boolean isTrueAnswer) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.option = option;
        this.isTrueAnswer = isTrueAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

    public Boolean getTrueAnswer() {
        return isTrueAnswer;
    }

    public void setTrueAnswer(Boolean trueAnswer) {
        isTrueAnswer = trueAnswer;
    }
}
