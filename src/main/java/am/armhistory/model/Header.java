package am.armhistory.model;

/**
 * Created by Gevorg Minasyan on 6/12/2017.
 */
public class Header {

    private Integer headerId;
    private String name;

    public Header(Integer headerId, String name) {
        this.headerId = headerId;
        this.name = name;
    }

    public Integer getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Integer headerId) {
        this.headerId = headerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
