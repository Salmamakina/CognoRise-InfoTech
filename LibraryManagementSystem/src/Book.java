public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "\n Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                '}';
    }
    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    public void checkOut() {
        isCheckedOut = true;
    }

    public void returnBook() {
        isCheckedOut = false;
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }
}
