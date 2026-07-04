package com.Three_Tyre_Auth_System.SupAdmin.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/api")
@RestController
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class SupAdmin {

    @GetMapping("/")
    public String UserController() {
        return "I am in Super Admin Controller";
    }

}
