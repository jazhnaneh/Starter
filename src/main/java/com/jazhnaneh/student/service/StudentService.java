package com.jazhnaneh.student.service;

import com.jazhnaneh.student.model.Student;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student addStudent(Student student, MultipartFile file);

    Student getStudent(Long id);

    String updateStudent(Long id, Student student);

    String deleteStudent(Long id);

    Page<Student> getAll(int page, int pageSize);

    @Transactional
    List<Student> filter(int page, int pageSize,String studentName,String studentFamily,Integer age);

 @Transactional
    List<Student> simplifiedFilter(int page, int pageSize, Predicate predicate);


}
