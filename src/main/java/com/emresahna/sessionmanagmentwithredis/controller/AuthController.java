package com.emresahna.sessionmanagmentwithredis.controller;

import com.emresahna.sessionmanagmentwithredis.dto.LoginDto;
import com.emresahna.sessionmanagmentwithredis.dto.RegisterDto;
import com.emresahna.sessionmanagmentwithredis.entity.User;
import com.emresahna.sessionmanagmentwithredis.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(userService.register(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto));
    }
}
