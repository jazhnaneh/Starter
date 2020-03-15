package com.jazhnaneh.student.controller;



import com.jazhnaneh.student.model.User;
import com.jazhnaneh.student.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UserServiceImpl usersService;

    @Autowired
    public UsersController(UserServiceImpl usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "" )
    public List<User> users() {
         return usersService.findAllUsers();
    }

    @RequestMapping(value = "/getUsers" , method = RequestMethod.GET)
    @ResponseBody
    public  List<User> getUsers() {
        return usersService.findAllUsers();
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public User registerUser(@RequestBody Map<String ,Object> values) {

     String userName= (String) values.get("userName");
     String password= (String) values.get("password");
     User user=new User();
     user.setUserName(userName);
     user.setPassword(new BCryptPasswordEncoder().encode(password));

     return usersService.registerUser(user);

    }


}
