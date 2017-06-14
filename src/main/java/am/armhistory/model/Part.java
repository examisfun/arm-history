package am.armhistory.model;

/**
 * Created by Gevorg Minasyan on 6/12/2017.
 */
public class Part {
    private Integer partId;
    private String name;

    public Part(Integer partId, String name) {
        this.partId = partId;
        this.name = name;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
