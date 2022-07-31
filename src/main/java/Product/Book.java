package Product;

public class Book extends Product {
    protected String bookName;
    protected String author;

    public Book(int id, String name, int price, String bookName, String author ) {
        super(id, name, price);
        this.bookName = bookName;
        this.author = author;
    }
}
