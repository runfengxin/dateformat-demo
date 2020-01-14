package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author xinrunfeng
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody User user) {
        System.out.println(user);
        System.out.println(user.getDateTime());
        return "ok";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get() {
        User user = new User();
        user.setUsername("xin");
        user.setDateTime(LocalDateTime.now());
        System.out.println(user);
        return user;
    }





}
