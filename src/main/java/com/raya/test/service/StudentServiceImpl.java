package com.raya.test.service;

import com.raya.test.exeption.NotFoundException;
import com.raya.test.model.Student;
import com.raya.test.repository.StudentRepo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

//    List<Student> list=new ArrayList<>();

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student addStudent(Student student, MultipartFile file) {

        try {
            student.setImageName(file.getOriginalFilename());
            student.setImageType(file.getContentType());
            student.setImage(IOUtils.toByteArray(file.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("addStudent " + e.getMessage());
        }

        studentRepo.save(student);

        return student;
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepo.findById(id);

        if (student.isPresent())
            return student.get();
        else
            throw new NotFoundException("this student  not found:" + id);

    }


    @Override
    public String updateStudent(Long id, String name, int age) {


        Optional<Student> student = studentRepo.findById(id);


        if (student.isPresent()) {

            Student test = student.get();

            test.setAge(age);
            test.setName(name);
            studentRepo.save(test);
        } else
            throw new RuntimeException();


        return "update shod";
    }

    @Override
    public String deleteStudent(Long id) {


        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {


            studentRepo.deleteById(id);
            return "delete shod";
        } else {

            throw new RuntimeException();


        }

    }

    @Override
    public Page<Student> getAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(

                Sort.Order.desc("id")
        ));
        Page<Student> testModels = studentRepo.findAll(pageable);
        return testModels;


    }
}
