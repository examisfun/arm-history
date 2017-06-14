package am.armhistory.model;

/**
 * Created by Gevorg Minasyan on 6/12/2017.
 */
public class Book {
    private Integer bookId;
    private String name;

    public Book(Integer bookId, String name) {
        this.bookId = bookId;
        this.name = name;
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
