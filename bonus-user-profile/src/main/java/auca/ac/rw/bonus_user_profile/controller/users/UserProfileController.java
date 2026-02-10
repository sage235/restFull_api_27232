package auca.ac.rw.bonus_user_profile.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.bonus_user_profile.model.ApiResponse;
import auca.ac.rw.bonus_user_profile.model.UserProfile;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private List<UserProfile> users = new ArrayList<>();

    // Sample data
    public UserProfileController() {
        users.add(new UserProfile(1L, "john_doe", "john@example.com",
                "John Doe", 76, "Rwanda", "Software Engineering student", true));
        users.add(new UserProfile(2L, "alice_m", "alice@example.com",
                "Alice", 2, "Rwanda", "Web developer", true));
        users.add(new UserProfile(3L, "paul_k", "paul@example.com",
                "Paul Kagame", 70, "Tchad", "Tech enthusiast", false));
    }

    // 1. GET all users
    @GetMapping
    public ApiResponse<List<UserProfile>> getAllUsers() {
        return new ApiResponse<>(true, "Users retrieved successfully", users);
    }

    // 2. GET user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> getUserById(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User found", user)
                );
            }
        }
        return new ResponseEntity<>(
                new ApiResponse<>(false, "User not found", null),
                HttpStatus.NOT_FOUND
        );
    }

    // 3. Search by username
    @GetMapping("/search/username")
    public ApiResponse<List<UserProfile>> searchByUsername(@RequestParam String username) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getUsername().toLowerCase().contains(username.toLowerCase())) {
                result.add(user);
            }
        }
        return new ApiResponse<>(true, "Search completed", result);
    }

    // 4. Search by country
    @GetMapping("/search/country/{country}")
    public ApiResponse<List<UserProfile>> searchByCountry(@PathVariable String country) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getCountry().equalsIgnoreCase(country)) {
                result.add(user);
            }
        }
        return new ApiResponse<>(true, "Users filtered by country", result);
    }

    // 5. Search by age range
    @GetMapping("/search/age")
    public ApiResponse<List<UserProfile>> searchByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {

        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getAge() >= min && user.getAge() <= max) {
                result.add(user);
            }
        }
        return new ApiResponse<>(true, "Users filtered by age range", result);
    }

    // 6. POST create user profile
    @PostMapping
    public ResponseEntity<ApiResponse<UserProfile>> createUser(@RequestBody UserProfile userProfile) {
        users.add(userProfile);
        return new ResponseEntity<>(
                new ApiResponse<>(true, "User profile created successfully", userProfile),
                HttpStatus.CREATED
        );
    }

    // 7. PUT update user profile
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> updateUser(
            @PathVariable Long userId,
            @RequestBody UserProfile updatedUser) {

        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
                user.setFullName(updatedUser.getFullName());
                user.setAge(updatedUser.getAge());
                user.setCountry(updatedUser.getCountry());
                user.setBio(updatedUser.getBio());
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User profile updated", user)
                );
            }
        }
        return new ResponseEntity<>(
                new ApiResponse<>(false, "User not found", null),
                HttpStatus.NOT_FOUND
        );
    }

    // 8. Activate user
    @PatchMapping("/{userId}/activate")
    public ResponseEntity<ApiResponse<UserProfile>> activateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(true);
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User activated", user)
                );
            }
        }
        return new ResponseEntity<>(
                new ApiResponse<>(false, "User not found", null),
                HttpStatus.NOT_FOUND
        );
    }

    // 9. Deactivate user
    @PatchMapping("/{userId}/deactivate")
    public ResponseEntity<ApiResponse<UserProfile>> deactivateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(false);
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User deactivated", user)
                );
            }
        }
        return new ResponseEntity<>(
                new ApiResponse<>(false, "User not found", null),
                HttpStatus.NOT_FOUND
        );
    }

    // 10. DELETE user profile
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                users.remove(user);
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User deleted successfully", null)
                );
            }
        }
        return new ResponseEntity<>(
                new ApiResponse<>(false, "User not found", null),
                HttpStatus.NOT_FOUND
        );
    }
}

