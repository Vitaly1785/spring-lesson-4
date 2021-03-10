package ru.geekbrains.springlesson4.productRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.geekbrains.springlesson4.product.Product;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductRepository {
    private static long AUTO_COUNT_ID;
    private List<Product> products;

    {
        products = new ArrayList<>();
        products.add(new Product(++AUTO_COUNT_ID, "Phone", 200));
        products.add(new Product(++AUTO_COUNT_ID, "HandsFree", 100));
        products.add(new Product(++AUTO_COUNT_ID, "Phone Glass", 75));
        products.add(new Product(++AUTO_COUNT_ID, "Battery", 80));
        products.add(new Product(++AUTO_COUNT_ID, "Charger", 65));
    }

    public List<Product> showAll() {
        return products;
    }

    public Product getById(long id) {
        return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    public void addProduct(Product product){
        product.setId(++AUTO_COUNT_ID);
        products.add(product);
    }
    public void update(long id, Product product){
        Product productToBeUpdated = getById(id);
        productToBeUpdated.setTitle(product.getTitle());
        productToBeUpdated.setCost(product.getCost());
    }
    public void delete(long id){
        products.removeIf(product -> product.getId() == id);
    }

}
