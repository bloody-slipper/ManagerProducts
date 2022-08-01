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

    Product product1 = new Product(1, "Над пропастью во ржи", 300);
    Product product2 = new Product(2, "Мастер и Маргарита", 400);

    Book book1 = new Book(3, "Повесть", 500, "Иллиада", "Гомер");
    Book book2 = new Book(4, "Повесть", 500, "Одиссея", "Гомер");

    Smartphone smartphone1 = new Smartphone(5, "смартфон", 30_000, "Galaxy", "Samsung");
    Smartphone smartphone2 = new Smartphone(5, "смартфон", 100_000, "iPhone", "Apple");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }


    @Test
    public void shouldSearchBy1() {

        manager.searchBy("Мастер");

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Мастер");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearch0() {

        manager.searchBy("пшеница");

        Product[] expected = manager.searchBy("пшеница");
        Product[] actual = manager.searchBy("пшеница");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByBook() {

        manager.searchBy("Повесть");

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Повесть");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBySmartphone() {

        manager.searchBy("смартфон");

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("смартфон");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchManufacturer() {

        manager.searchBy("samsung");

        Product[] expected = {smartphone2};
        Product[] actual = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);

    }


}
