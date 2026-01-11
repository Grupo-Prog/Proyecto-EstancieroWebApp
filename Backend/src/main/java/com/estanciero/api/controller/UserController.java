package com.estanciero.api.controller;
import com.estanciero.api.dto.UserCreateRequestDTO;
import com.estanciero.api.dto.UserResponseDTO;
import com.estanciero.api.dto.UserUpdateRequestDTO;
import com.estanciero.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching for all users");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        try {
            UserResponseDTO user = userService.findById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching for user");
        }
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(userService.findByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching for user by email");
        }
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(userService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching for users by name");
        }
    }

    // POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateRequestDTO request) {
        try {
            UserResponseDTO created = userService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody UserUpdateRequestDTO request) {
        try {
            UserResponseDTO updated = userService.update(id, request);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating the user");
        }
    }

    // DELETE --> change to baja logica capo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }
}
