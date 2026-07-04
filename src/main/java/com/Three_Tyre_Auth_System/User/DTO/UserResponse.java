package com.Three_Tyre_Auth_System.User.DTO;
import com.Three_Tyre_Auth_System.User.Entity.Enum.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private Role role;

}
