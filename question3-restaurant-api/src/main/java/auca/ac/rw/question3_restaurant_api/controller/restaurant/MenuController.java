package auca.ac.rw.question3_restaurant_api.controller.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.question3_restaurant_api.modal.restaurant.MenuItem;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    // In-memory menu list
    private List<MenuItem> menuItems = new ArrayList<>();

    // Initialize sample menu items (8 items)
    public MenuController() {
        menuItems.add(new MenuItem(1L, "Spring Rolls", "Crispy vegetable rolls", 5.99, "Appetizer", true));
        menuItems.add(new MenuItem(2L, "Garlic Bread", "Toasted bread with garlic butter", 4.49, "Appetizer", true));
        menuItems.add(new MenuItem(3L, "Grilled Chicken", "Grilled chicken with spices", 12.99, "Main Course", true));
        menuItems.add(new MenuItem(4L, "Beef Steak", "Juicy grilled beef steak", 18.99, "Main Course", false));
        menuItems.add(new MenuItem(5L, "Chocolate Cake", "Rich chocolate dessert", 6.99, "Dessert", true));
        menuItems.add(new MenuItem(6L, "Ice Cream", "Vanilla ice cream scoop", 3.99, "Dessert", true));
        menuItems.add(new MenuItem(7L, "Orange Juice", "Fresh orange juice", 2.99, "Beverage", true));
        menuItems.add(new MenuItem(8L, "Coffee", "Hot brewed coffee", 1.99, "Beverage", false));
    }

    // GET /api/menu
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(menuItems); // 200 OK
    }

    // GET /api/menu/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                return ResponseEntity.ok(item); // 200 OK
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
    }

    // GET /api/menu/category/{category}
    @GetMapping("/category/{category}")
    public ResponseEntity<List<MenuItem>> getItemsByCategory(@PathVariable String category) {
        List<MenuItem> result = new ArrayList<>();

        for (MenuItem item : menuItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }

        return ResponseEntity.ok(result); // 200 OK
    }

    // GET /api/menu/available?available=true
    @GetMapping("/available")
    public ResponseEntity<List<MenuItem>> getAvailableItems(@RequestParam boolean available) {
        List<MenuItem> result = new ArrayList<>();

        for (MenuItem item : menuItems) {
            if (item.getAvailable() == available) {
                result.add(item);
            }
        }

        return ResponseEntity.ok(result); // 200 OK
    }

    // GET /api/menu/search?name={name}
    @GetMapping("/search")
    public ResponseEntity<List<MenuItem>> searchMenuItems(@RequestParam String name) {
        List<MenuItem> result = new ArrayList<>();

        for (MenuItem item : menuItems) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }

        return ResponseEntity.ok(result); // 200 OK
    }

    // POST /api/menu
    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        menuItems.add(menuItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItem); // 201 Created
    }

    // PUT /api/menu/{id}/availability
    @PutMapping("/{id}/availability")
    public ResponseEntity<MenuItem> toggleAvailability(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.getAvailable());
                return ResponseEntity.ok(item); // 200 OK
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
    }

    // DELETE /api/menu/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                menuItems.remove(item);
                return ResponseEntity.noContent().build(); // 204 No Content
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
    }
}
