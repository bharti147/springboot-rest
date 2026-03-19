package com.sb.springboot_rest.service;

import com.sb.springboot_rest.repo.UserRepo;
import com.sb.springboot_rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user){
        user.setPassword(encoder.encode((user.getPassword())));
        return repo.save(user);
    }

}
