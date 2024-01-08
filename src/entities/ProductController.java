package entities;

public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.setProductService(productService);
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}