import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("The fault in our stars", "John Green");
        Book book3 = new Book("The great Gatsby", "Scott Fitzgerald");
        Book book4 = new Book("To kill a Mockingbird", "Harper Lee");


        catalog.addBooks(book1);
        catalog.addBooks(book2);
        catalog.addBooks(book3);
        catalog.addBooks(book4);

        System.out.printf("All books in the catalog: \n");
        catalog.displayBook();

        System.out.printf("\n /***********************************/\n");

        System.out.printf("\nSearch by title '1984':\n");
        ArrayList<Book> searchResults = catalog.searchByTitle("1984");
        for (Book book : searchResults) {
            System.out.printf(book.toString());

        }
        System.out.printf("\n/***********************************/\n");

        System.out.printf("\nSearch by author 'John Green':\n");
        ArrayList<Book> searchResultss = catalog.searchByAuthor("John Green");
        for (Book book : searchResultss) {
            System.out.printf(book.toString());

        }
        System.out.printf("\n/***********************************/\n");
        System.out.printf("\nChecking out '1984'!");
        if (catalog.CheckOutBook("1984")){
            System.out.printf("\nSuccessfully checked out '1984'.");
        }
        else {
            System.out.printf("\n'1984' is not available.");
        }

    }

}