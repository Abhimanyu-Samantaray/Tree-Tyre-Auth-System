package com.Three_Tyre_Auth_System.User.DTO;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;

}
