package Product;

import org.jetbrains.annotations.NotNull;

public class ProductManager {
    protected Repository repo;
    protected Product[] items = new Product[0];

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product item : repo.getProduct()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i]= result[i];
                }
                tmp[tmp.length - 1] = item;
                result = tmp;
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product item, String search) {
        if (item.getProduct().contains(search)) {
            return true;
        } else {
            return false;
        }
    }


}


