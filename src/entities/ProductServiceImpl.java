package entities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        try {
            return products.stream()
                    .filter(product -> product.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " not found."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("All products:\n");
        products.forEach(product -> {
            String productName = product.getName().isEmpty() ? "[No Name]" : product.getName();
            result.append("Name: ").append(productName).append("\n")
                    .append("Price: ").append(product.getPrice()).append("\n");
        });
        return result.toString();
    }

    public void removeProductById(int productId) {
        try {
            products.removeIf(product -> product.getId() == productId);
        } catch (Exception e) {
            System.out.println("Error removing product: " + e.getMessage());
        }
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }
    
 // Método para salvar produtos em um arquivo
    public void saveToFile(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(products);
            System.out.println("Products saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }

    // Método para carregar produtos de um arquivo
    @SuppressWarnings("unchecked")
	public void loadFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            products = (List<Product>) inputStream.readObject();
            System.out.println("Products loaded from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading products from file: " + e.getMessage());
        }
    }
}
