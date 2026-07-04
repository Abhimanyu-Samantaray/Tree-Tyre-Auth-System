package com.Three_Tyre_Auth_System.User.Controller;

import com.Three_Tyre_Auth_System.User.DTO.LoginRequest;
import com.Three_Tyre_Auth_System.User.DTO.LoginResponse;
import com.Three_Tyre_Auth_System.User.DTO.RegisterRequest;
import com.Three_Tyre_Auth_System.User.DTO.UserResponse;
import com.Three_Tyre_Auth_System.User.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth/api")
@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
         return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserByID(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }


}
