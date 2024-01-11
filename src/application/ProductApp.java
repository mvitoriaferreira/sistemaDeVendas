package application;

import entities.Product;
import entities.ProductController;
import entities.ProductService;
import entities.ProductServiceImpl;

public class ProductApp {

    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        ProductController productController = new ProductController(productService);

        // Adicione seus produtos conforme necessário (opcional)
        Product product1 = new Product(1, "Product A", 19.99);
        Product product2 = new Product(2, "Product B", 29.99);
        productService.addProduct(product1);
        productService.addProduct(product2);

        // Inicie a interação do usuário
        productController.start();
    }
}
