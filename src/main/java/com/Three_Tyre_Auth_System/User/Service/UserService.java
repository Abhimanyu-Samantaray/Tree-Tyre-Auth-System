package com.Three_Tyre_Auth_System.User.Service;

import com.Three_Tyre_Auth_System.User.DTO.LoginRequest;
import com.Three_Tyre_Auth_System.User.DTO.LoginResponse;
import com.Three_Tyre_Auth_System.User.DTO.RegisterRequest;
import com.Three_Tyre_Auth_System.User.DTO.UserResponse;
import com.Three_Tyre_Auth_System.User.Entity.User;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public interface UserService {

    UserResponse register(RegisterRequest request);

    UserResponse getUserById(Long id);

    @Nullable LoginResponse loginUser(LoginRequest request);

    Optional<UserResponse> getUserDetails(String username);

    //List<UserResponse> getAllUsers();

    //UserResponse updateUser(Long id, UpdateUserRequest request);

    //void deleteUser(Long id);

}
