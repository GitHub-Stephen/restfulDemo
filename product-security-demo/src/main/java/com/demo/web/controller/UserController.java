package com.demo.web.controller;


import com.demo.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * demo
 * @author Stephen
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public List<User> getUserInfo(){
        List<User> resultList = new ArrayList<>();
        User user1 = new User();
        user1.setName("haha");
        User user2 = new User();
        user2.setName("hehe");
        User user3 = new User();
        user3.setName("xix1");
        resultList.add(user1);
        resultList.add(user2);
        resultList.add(user3);
        return resultList;
    }

}
