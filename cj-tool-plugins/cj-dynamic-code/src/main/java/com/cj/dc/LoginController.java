package com.cj.dc;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/test1")
    public String Logout(HttpServletRequest request) {
        return "hello jin";
    }

}