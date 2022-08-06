package Prodact;

import Product.Product;
import Product.Repository;
import Product.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Repository repo = new Repository();


    Product product1 = new Product(1, "книга", 300);
    Product product2 = new Product(2, "книга", 400);
    Product product3 = new Product(3, "книга", 500);



    @Test
    public void shouldSaveProduct() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProduct() {
        Repository repo = new Repository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindException() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(55));
    }



}
