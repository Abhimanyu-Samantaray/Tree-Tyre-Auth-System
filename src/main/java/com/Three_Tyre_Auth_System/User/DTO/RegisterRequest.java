package com.Three_Tyre_Auth_System.User.DTO;

import lombok.Data;

@Data
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String password;

}
