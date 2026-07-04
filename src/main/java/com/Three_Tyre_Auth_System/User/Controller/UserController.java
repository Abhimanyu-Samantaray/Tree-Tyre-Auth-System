package com.Three_Tyre_Auth_System.User.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user/api")
@RestController
@PreAuthorize("hasRole('USER')")
public class UserController {

    @GetMapping("/user")
    public String UserController() {
        return "I am in user Controller";
    }

}
