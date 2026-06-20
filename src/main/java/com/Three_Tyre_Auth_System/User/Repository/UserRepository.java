package com.Three_Tyre_Auth_System.User.Repository;

import com.Three_Tyre_Auth_System.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByMobileNo(String mobileNo);

    boolean existsByEmail(String email);

    boolean existsByMobileNo(String mobileNo);

}
