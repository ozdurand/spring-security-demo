package com.datajabs.springjwtsecurityapp.resource;

import com.datajabs.springjwtsecurityapp.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @GetMapping("/home")
    public String showUser() {
        return "Application WORKS!!!!!";
    }
}
