package entities;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
	private List<Product> products;
	
	public ProductServiceImpl() {
        this.products = new ArrayList<>();
    }

	@Override
	public void addProduct(Product product) {
		products.add(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return new ArrayList<>(products);
	}

	@Override
	public Product getProductById(int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}
	
	@Override
    public String toString() {
        String result = "All products:\n";
        for (Product product : products) {
            String productName = product.getName().isEmpty() ? "[No Name]" : product.getName();
            result += "Name: " + productName + "\n" +
                      "Price: " + product.getPrice() + "\n";
        }
        return result;
    }
}