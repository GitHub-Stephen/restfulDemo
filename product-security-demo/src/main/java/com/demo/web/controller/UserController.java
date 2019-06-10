package com.demo.web.controller;


import com.demo.web.dto.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value="/user",method = RequestMethod.GET)
    public List<User> user(){
        List<User> result = new ArrayList<>();
        User user1 = new User();
        user1.setName("jack");
        user1.setPassword("222");
        result.add(user1);

        return result;
    }

}
