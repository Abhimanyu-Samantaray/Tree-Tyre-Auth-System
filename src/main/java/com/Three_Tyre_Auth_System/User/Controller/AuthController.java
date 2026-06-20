package com.Three_Tyre_Auth_System.User.Controller;

import com.Three_Tyre_Auth_System.User.DTO.RegisterRequest;
import com.Three_Tyre_Auth_System.User.DTO.UserResponse;
import com.Three_Tyre_Auth_System.User.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth/api/user")
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


}
