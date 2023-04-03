package com.emresahna.sessionmanagmentwithredis.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    private final HttpSession httpSession;

    public HomeService(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public String getHome() {
        String username = (String) httpSession.getAttribute("username");
        if (username == null) {
            return "Please login first";
        }
        return "Welcome " + username;
    }
}
