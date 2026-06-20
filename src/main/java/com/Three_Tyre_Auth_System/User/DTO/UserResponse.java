package com.Three_Tyre_Auth_System.User.DTO;
import com.Three_Tyre_Auth_System.User.Entity.Enum.Role;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private Role role;

}
