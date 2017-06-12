package am.armhistory.model;

/**
 * Created by Gevorg Minasyan on 6/12/2017.
 */
public class Header {
    private Integer headerId;
    private Integer subjectId;
    private String name;

    public Header(Integer headerId, Integer subjectId, String name) {
        this.headerId = headerId;
        this.subjectId = subjectId;
        this.name = name;
    }

    public Header() {
    }

    public Integer getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Integer headerId) {
        this.headerId = headerId;
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
