package com.smartyatra.smart_yatra_backend.controller;


import com.smartyatra.smart_yatra_backend.dto.AuthResponse;
import com.smartyatra.smart_yatra_backend.dto.LoginRequest;
import com.smartyatra.smart_yatra_backend.dto.RegisterRequest;
import com.smartyatra.smart_yatra_backend.dto.UpdateUserRequest;
import com.smartyatra.smart_yatra_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        System.out.println("Register API called for: " + request.getEmail());
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        AuthResponse authResponse = authService.login(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authResponse);

    }

    @PutMapping("/update")
    public ResponseEntity<AuthResponse> updateUser(@RequestBody UpdateUserRequest request) {
        System.out.println("Update API called for: " + request.getEmail());
        return new ResponseEntity<>(authService.updateUser(request), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from a secured endpoint!");
    }
}