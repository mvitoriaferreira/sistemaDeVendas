package entities;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductController {
	
	private ProductService productService;
	private Scanner scanner;

	public ProductController(ProductService productService) {
		this.productService = productService;
		this.scanner = new Scanner(System.in);
	}

	public void start() {
		int choice;
		do {
			System.out.println("1. Add Product");
			System.out.println("2. List All Products");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addProduct();
				break;
			case 2:
				listAllProducts();
				break;
			case 3:
				System.out.println("Exiting the program. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 3);
	}

	private void addProduct() {
        try {
            System.out.print("Enter product name: ");
            String name = scanner.next();
            name += scanner.nextLine();

            double price;
            while (true) {
                System.out.print("Enter product price: ");
                try {
                    price = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for the price.");
                }
            }

            Product product = new Product(generateProductId(), name, price);
            productService.addProduct(product);

            System.out.println("Product added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number for the price.");
            scanner.nextLine();
        }
    }

	private void listAllProducts() {
		System.out.println(productService.toString());
	}

	private int generateProductId() {
		// Implementação para gerar IDs únicos para produtos
		return productService.getAllProducts().size() + 1;
	}
}
