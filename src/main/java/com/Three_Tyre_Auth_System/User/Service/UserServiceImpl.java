package com.Three_Tyre_Auth_System.User.Service;

import com.Three_Tyre_Auth_System.User.DTO.RegisterRequest;
import com.Three_Tyre_Auth_System.User.DTO.UserResponse;
import com.Three_Tyre_Auth_System.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse register(RegisterRequest request) {
        // Logic here
    }

    @Override
    public UserResponse getUserById(Long id) {
        // Logic here
    }
}
