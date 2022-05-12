package bstorm.akimts.demouserdetails.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String isConnected(){
        return "vous êtes connecté";
    }

}
