package com.akira.invoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController  // Changed from @RestController
public class UserController {
    
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard.html";
    }
    
    @GetMapping("/invoice")
    public String invoice() {
        return "invoice.html";
    }
    @GetMapping("/test-auth")
	@ResponseBody
    public String testAuth(Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            return "Authenticated as: " + auth.getName() + " with roles: " + auth.getAuthorities();
        }
        return "Not authenticated";
    }   
}
