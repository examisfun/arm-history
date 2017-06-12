package am.armhistory.model;

/**
 * Created by Gevorg Minasyan on 6/12/2017.
 */
public class Part {
    private Integer partId;
    private Integer bookId;
    private String name;

    public Part(Integer partId, Integer bookId, String name) {
        this.partId = partId;
        this.bookId = bookId;
        this.name = name;
    }

    public Part() {
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
