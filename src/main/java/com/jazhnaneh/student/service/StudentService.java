package com.jazhnaneh.student.service;

import com.jazhnaneh.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student addStudent(Student student, MultipartFile file);

    Student getStudent(Long id);

    String updateStudent(Long id, Student student);

    String deleteStudent(Long id);

    Page<Student> getAll(int page, int pageSize);


}
