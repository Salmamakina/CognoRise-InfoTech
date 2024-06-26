import java.util.ArrayList;
public class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }
     public void addBooks(Book book){
        books.add(book);
     }
     public ArrayList<Book> searchByTitle(String title){
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                results.add(book);
            }
        }
        return results;
    }
    public ArrayList<Book> searchByAuthor(String author){
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books){
            if(book.getAuthor().equalsIgnoreCase(author)){
                results.add(book);
            }
        }
        return results;
    }
    public boolean CheckOutBook(String title){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()){
                book.checkOut();
                return true;
            }
        }
        return false;
    }
    public void displayBook(){
        for (Book book : books){
            System.out.printf(book.toString());
        }
    }

}



