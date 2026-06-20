package com.Three_Tyre_Auth_System.User.Service;

import com.Three_Tyre_Auth_System.User.DTO.RegisterRequest;
import com.Three_Tyre_Auth_System.User.DTO.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse register(RegisterRequest request);

    UserResponse getUserById(Long id);

    //List<UserResponse> getAllUsers();

    //UserResponse updateUser(Long id, UpdateUserRequest request);

    //void deleteUser(Long id);

}
