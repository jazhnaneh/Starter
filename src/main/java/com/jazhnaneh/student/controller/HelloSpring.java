package com.jazhnaneh.student.controller;


import com.jazhnaneh.student.model.Student;
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
