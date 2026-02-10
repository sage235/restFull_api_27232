package auca.ac.rw.question4_ecommerce_api.controller.ecommerce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.question4_ecommerce_api.modal.ecommerce.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "iPhone 14", "Apple smartphone", 999.99, "Electronics", 10, "Apple"));
        products.add(new Product(2L, "Galaxy S23", "Samsung smartphone", 899.99, "Electronics", 5, "Samsung"));
        products.add(new Product(3L, "MacBook Pro", "Apple laptop", 1999.99, "Computers", 3, "Apple"));
        products.add(new Product(4L, "Dell XPS", "Dell laptop", 1499.99, "Computers", 0, "Dell"));
        products.add(new Product(5L, "Sony Headphones", "Noise cancelling headphones", 299.99, "Accessories", 15, "Sony"));
        products.add(new Product(6L, "Logitech Mouse", "Wireless mouse", 49.99, "Accessories", 20, "Logitech"));
        products.add(new Product(7L, "Nike Shoes", "Running shoes", 129.99, "Fashion", 8, "Nike"));
        products.add(new Product(8L, "Adidas Jacket", "Sports jacket", 99.99, "Fashion", 0, "Adidas"));
        products.add(new Product(9L, "Samsung TV", "4K Smart TV", 799.99, "Electronics", 4, "Samsung"));
        products.add(new Product(10L, "Apple Watch", "Smart watch", 399.99, "Wearables", 6, "Apple"));
    }

    // GET /api/products?page={page}&limit={limit}
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {

        int start = page * limit;
        int end = Math.min(start + limit, products.size());

        if (start > products.size()) {
            return ResponseEntity.ok(new ArrayList<>());
        }

        return ResponseEntity.ok(products.subList(start, end)); // 200 OK
    }

    // GET /api/products/{productId}
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return ResponseEntity.ok(product); // 200 OK
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
    }

    // GET /api/products/category/{category}
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String category) {
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result); // 200 OK
    }

    // GET /api/products/brand/{brand}
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getByBrand(@PathVariable String brand) {
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result); // 200 OK
    }

    // GET /api/products/search?keyword={keyword}
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result); // 200 OK
    }

    // GET /api/products/price-range?min={min}&max={max}
    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getByPriceRange(
            @RequestParam Double min,
            @RequestParam Double max) {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result); // 200 OK
    }

    // GET /api/products/in-stock
    @GetMapping("/in-stock")
    public ResponseEntity<List<Product>> getInStockProducts() {
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getStockQuantity() > 0) {
                result.add(product);
            }
        }
        return ResponseEntity.ok(result); // 200 OK
    }

    // POST /api/products
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product); // 201 Created
    }

    // PUT /api/products/{productId}
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product updatedProduct) {

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                product.setCategory(updatedProduct.getCategory());
                product.setBrand(updatedProduct.getBrand());
                product.setStockQuantity(updatedProduct.getStockQuantity());

                return ResponseEntity.ok(product); // 200 OK
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
    }

    // PATCH /api/products/{productId}/stock?quantity={quantity}
    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(
            @PathVariable Long productId,
            @RequestParam int quantity) {

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setStockQuantity(quantity);
                return ResponseEntity.ok(product); // 200 OK
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
    }

    // DELETE /api/products/{productId}
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                products.remove(product);
                return ResponseEntity.noContent().build(); // 204 No Content
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
    }
}
