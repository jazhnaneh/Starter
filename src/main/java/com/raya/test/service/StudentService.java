package com.raya.test.service;

import com.raya.test.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student  addStudent(Student student);
    Student  getStudent(Long id);
    String  updateStudent(Long id,String name,int age);
    String  deleteStudent(Long id);



    Page<Student> getAll(int page, int pageSize);

}
