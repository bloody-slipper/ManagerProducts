package Prodact;

import Product.Product;
import Product.Repository;
import Product.ProductManager;
import Product.Book;
import Product.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(4, "книга", 500, "Над пропастью во ржи", "Джером Сэлинджер");
    Book book2 = new Book(5, "книга", 600, "Мастер и Маргарита", "Михаил Булгаков");
    Book book3 = new Book(6, "книга", 700, "Иллиада", "Гомер");
    Smartphone smartphone1 = new Smartphone(7, "смартфон", 100_000, "iPhone 12 Pro", "Apple");
    Smartphone smartphone2 = new Smartphone(8, "смартфон", 30_000, "Galaxy M5", "Samsung");


    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }


    @Test
    public void shouldSearchByAuthor() {

        manager.searchBy("гомер");

        Product[] expected = {book2};
        Product[] actual = {book2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByBookName() {

        manager.searchBy("мастер");

        Product[] expected = {book3};
        Product[] actual = {book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchSmartphoneName() {

        manager.searchBy("iphone");

        Product[] expected = {smartphone1};
        Product[] actual = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchManufacturer() {

        manager.searchBy("samsung");

        Product[] expected = {smartphone2};
        Product[] actual = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldMatches() {
        manager.searchBy("книга");

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("книга");

        Assertions.assertArrayEquals(expected, actual);

    }


}
