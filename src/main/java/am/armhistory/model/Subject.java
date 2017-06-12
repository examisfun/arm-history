package am.armhistory.model;

/**
 * Created by Gevorg Minasyan on 6/11/2017.
 */
public class Subject {
    
    private Integer subjectId;
    private String name;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(Integer subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
