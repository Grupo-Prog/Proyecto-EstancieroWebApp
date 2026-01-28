package com.estanciero.api.controllers;
import com.estanciero.api.dtos.UserCreateRequestDTO;
import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.dtos.UserUpdateRequestDTO;
import com.estanciero.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable long id) {
        UserResponseDTO user = userService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return ResponseEntity.ok(user);
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> findByEmail(@PathVariable String email) {
        UserResponseDTO user = userService.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("User email not found"));
        return ResponseEntity.ok(user);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserResponseDTO>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.findByName(name));
    }

    // POST
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserCreateRequestDTO request) {
        UserResponseDTO created = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable long id, @RequestBody UserUpdateRequestDTO request) {
        UserResponseDTO updated = userService.update(id, request);
        return ResponseEntity.ok(updated);
    }

    // DELETE --> change to baja logica capo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
