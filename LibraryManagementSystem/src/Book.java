public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                '}';
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }
}
