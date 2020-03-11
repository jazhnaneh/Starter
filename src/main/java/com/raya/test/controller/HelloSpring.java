package com.raya.test.controller;


import com.raya.test.model.Student;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloSpring {


    @GetMapping("/get")
    public String getData(){

        return "first test";
    }

    @PostMapping("/get")
    public String postData(@RequestBody @Valid Student param){

        return "postData :"+param.toString();
    }

    @PutMapping("/get")
    public String PutMapping(){

        return "PutMapping";
    }

    @PatchMapping("/get")
    public String PatchMapping(){

        return "PatchMapping";
    }
   @DeleteMapping("/get")
    public String DeleteMapping(){

        return "DeleteMapping";
    }



}
