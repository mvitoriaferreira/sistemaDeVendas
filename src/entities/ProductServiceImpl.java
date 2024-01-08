package entities;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private List<Product> products;

	@Override
	public void addProduct(Product product) {
				
	}

	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public Product getProductById(int id) {
		return null;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}