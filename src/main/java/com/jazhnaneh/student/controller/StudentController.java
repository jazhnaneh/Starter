package com.jazhnaneh.student.controller;


import com.jazhnaneh.student.dto.StudentDTO;
import com.jazhnaneh.student.mapper.StudentMapper;
import com.jazhnaneh.student.model.Student;
import com.jazhnaneh.student.service.StudentServiceImpl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    StudentMapper studentMapper;


    @GetMapping("/getAll")
    public List<StudentDTO> getAllData() {
        return studentMapper.toStudentsDTO(studentService.getAll());
    }


    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@RequestBody @Valid StudentDTO studentDTO, @PathVariable("id") Long id) {
        return studentService.updateStudent(id, studentMapper.toStudentEntity(studentDTO));
    }


    @GetMapping("/getAll/{page}/{size}")
    public List<StudentDTO> getAll(@PathVariable("page") int page, @PathVariable("size") int size) {
        return studentMapper.toStudentsDTO(studentService.getAll(page, size));
    }


    @ApiOperation(value = "Add or insert student")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Added successfully"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 409, message = "It is duplicate"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/addStudent")
    public ResponseEntity<Void> addStudent(@Valid StudentDTO studentDTO, @RequestPart("student_image") MultipartFile file) {
        studentService.addStudent(studentMapper.toStudentEntity(studentDTO), file);
        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }


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

    @GetMapping
    public ResponseEntity<List<StudentDTO>> students(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "500") int size,
            @RequestParam(name = "studentName", required = false) String studentName,
            @RequestParam(name = "studentFamily", required = false) String studentFamily,
            @RequestParam(name = "age", required = false) Integer age) {


        List<Student> studentList = studentService.filter(page, size, studentName, studentFamily, age);
        List<StudentDTO> studentDTOS = studentMapper.toStudentsDTO(studentList);
        return ResponseEntity.ok(studentDTOS);


    }

    @GetMapping("/simplified")
    public ResponseEntity<List<StudentDTO>> filterStudents(
            @QuerydslPredicate(root = Student.class) Predicate predicate,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "500") int size
    ) {


        List<Student> studentList = studentService.simplifiedFilter(page, size, predicate);
        List<StudentDTO> studentDTOS = studentMapper.toStudentsDTO(studentList);
        return ResponseEntity.ok(studentDTOS);


    }

}
