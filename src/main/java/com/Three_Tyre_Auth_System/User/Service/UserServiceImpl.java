package com.Three_Tyre_Auth_System.User.Service;

import com.Three_Tyre_Auth_System.HandleGlobalException.InvalidCredentialsException;
import com.Three_Tyre_Auth_System.HandleGlobalException.UserNotFoundException;
import com.Three_Tyre_Auth_System.User.DTO.LoginRequest;
import com.Three_Tyre_Auth_System.User.DTO.LoginResponse;
import com.Three_Tyre_Auth_System.User.DTO.RegisterRequest;
import com.Three_Tyre_Auth_System.User.DTO.UserResponse;
import com.Three_Tyre_Auth_System.User.Entity.User;
import com.Three_Tyre_Auth_System.User.Repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public UserResponse register(RegisterRequest request) {

        User user = new User();

        user.setFirst_name(request.getFirstName());
        user.setLast_name(request.getLastName());
        user.setEmail(request.getEmail());
        user.setMobileNo(request.getMobileNo());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        return getUserResponse(savedUser);
    }

    @NonNull
    private UserResponse getUserResponse(User savedUser) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setFirstName(savedUser.getFirst_name());
        userResponse.setLastName(savedUser.getLast_name());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setMobileNo(savedUser.getMobileNo());
        userResponse.setRole(savedUser.getRole());

        return userResponse;
    }

    @Override
    public UserResponse getUserById(Long id) {

        Optional<User> userDetails = userRepository.findById(id);


        if (userDetails.isEmpty()) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }

        User getUser = userDetails.get();

        return getUserResponse(getUser);

    }

    @Override
    public @Nullable LoginResponse loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException(request.getEmail() + " User with this email is Not Found"));


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid Password Please Check");
        }

        String token = jwtService.generateToken(user.getId(), user.getEmail(), String.valueOf(user.getRole()));

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setMessage("Login Successfully");
        loginResponse.setToken(token);

        return loginResponse;
    }

    @Override
    public Optional<UserResponse> getUserDetails(String username) {
        Optional<User> userDetails = userRepository.findByEmail(username);
        return userDetails.map(this::getUserResponse);
    }

}
