package entities;

import java.util.List;

public interface ProductService {
	void addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int id);
}