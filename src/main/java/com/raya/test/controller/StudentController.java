package com.raya.test.controller;


import com.raya.test.model.Student;
import com.raya.test.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;


    @GetMapping("/getAll")
    public List<Student> getAllData(){

        return studentService.getAll();
    }

    @GetMapping("/updateStudent/{name}/{age}")
    public String updateStudent(@PathVariable("name") String name,@PathVariable("age") int age){

        return studentService.updateStudent(name,age);
    }


    @GetMapping("/getAll/{page}/{size}")
    public Page<Student> getAll(@PathVariable("page") int page, @PathVariable("size") int size) {

        return studentService.getAll(page, size);

    }





    @PostMapping("/addStudent")
    public ResponseEntity<Void> addStudent(@RequestBody @Valid Student param){

        studentService.addStudent(param);

        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }
//
//    @PutMapping("/get")
//    public String PutMapping(){
//
//        return "PutMapping";
//    }
//
//    @PatchMapping("/get")
//    public String PatchMapping(){
//
//        return "PatchMapping";
//    }
   @GetMapping("/delete/{id}")
    public String DeleteMapping(@PathVariable("id") Long id){
       studentService.deleteStudent(id);
        return "delet shod ba in id:"+id;
    }


}
