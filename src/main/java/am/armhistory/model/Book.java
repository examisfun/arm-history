package am.armhistory.model;

/**
 * Created by Gevorg Minasyan on 6/12/2017.
 */
public class Book {
    Integer bookId;
    Integer subjectId;
    String name;

    public Book(Integer bookId, Integer subjectId, String name) {
        this.bookId = bookId;
        this.subjectId = subjectId;
        this.name = name;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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
