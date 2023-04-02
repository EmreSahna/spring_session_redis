package com.emresahna.sessionmanagmentwithredis.service;

import com.emresahna.sessionmanagmentwithredis.dto.LoginDto;
import com.emresahna.sessionmanagmentwithredis.dto.RegisterDto;
import com.emresahna.sessionmanagmentwithredis.entity.User;
import com.emresahna.sessionmanagmentwithredis.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public UserService(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    public User register(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        return userRepository.save(user);
    }

    public String login(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if (user != null && user.getPassword().equals(loginDto.getPassword())) {
            httpSession.setAttribute("username", loginDto.getUsername());
            return "Successfully logged in";
        }
        return "Invalid username or password";
    }
}
