package am.armhistory.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Gevorg Minasyan on 6/10/2017.
 */
public class QuestionDto implements Serializable {

    private static final long serialVersionUID = 6272350872497975378L;

    public final Integer id;

    public final String question;

    public final Map<Integer, String> answers;

    public final Integer rightAnswer;


    @JsonCreator
    public QuestionDto(@JsonProperty("id") Integer id, @JsonProperty("question")  String question,
                       @JsonProperty("rightAnswer") Integer rightAnswer, @JsonProperty("answers") Map<Integer, String> answers) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers = answers;
    }
}
