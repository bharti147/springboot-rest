package com.sb.springboot_rest.repo;

import com.sb.springboot_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
   User findByUsername(String username);
}
