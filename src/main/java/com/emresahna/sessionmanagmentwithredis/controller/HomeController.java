package com.emresahna.sessionmanagmentwithredis.controller;

import com.emresahna.sessionmanagmentwithredis.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(homeService.getHome());
    }
}
