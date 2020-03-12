package com.raya.test.controller;


import com.raya.test.model.Student;
import com.raya.test.service.StudentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;


    @GetMapping("/getAll")
    public List<Student> getAllData() {

        return studentService.getAll();
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@RequestBody Map<String, Object> data) {

        String name = (String) data.get("name");
        Long id = ((Number) data.get("id")).longValue();
        int age = (int) data.get("age");


        return studentService.updateStudent(id, name, age);
    }


    @GetMapping("/getAll/{page}/{size}")
    public Page<Student> getAll(@PathVariable("page") int page, @PathVariable("size") int size) {

        return studentService.getAll(page, size);

    }


    @ApiOperation(value = "Add or insert student")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Added successfully"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 409, message = "It is duplicate"),
            @ApiResponse(code = 500, message = "Server error")
    })

    @PostMapping(value = "/addStudent")
    public ResponseEntity<Void> addStudent(@Valid Student param, @RequestPart("user_image") MultipartFile file) {

        studentService.addStudent(param, file);

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
    public String DeleteMapping(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "delet shod ba in id:" + id;
    }

 @GetMapping(value = "/getStudentProfileImage/{id}")
    public ResponseEntity<ByteArrayResource> getStudentProfileImage(@PathVariable("id") Long id) {
     Student student = studentService.getStudent(id);
     return ResponseEntity.ok()
             .contentType(MediaType.parseMediaType(student.getImageType()))
             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + student.getImageName() + "\"")
             .body(new ByteArrayResource(student.getImage()));
    }


}
