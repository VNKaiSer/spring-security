package com.example.springserurity.services.impl;

import com.example.springserurity.models.User;
import com.example.springserurity.repositories.UserRepository;
import com.example.springserurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserRepository userRepository;
    @Autowired  private PasswordEncoder passwordEncoder;


    @Override
    public boolean addUser(User user) {
        try {
            String pass = user.getPassword();
            user.setPassword(passwordEncoder.encode(pass));
            userRepository.save(user);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
