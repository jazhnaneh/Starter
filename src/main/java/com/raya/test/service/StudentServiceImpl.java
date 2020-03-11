package com.raya.test.service;

import com.raya.test.model.Student;
import com.raya.test.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Student addStudent(Student student) {


        studentRepo.save(student);

        return student;
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student=studentRepo.findById(id);

        if (student.isPresent())
            return  student.get();
        else
            throw new RuntimeException();

    }

    @Override
    public String updateStudent(String name,int age) {


        Optional<Student> student = studentRepo.findByName(name);


        if (student.isPresent()) {

            Student test = student.get();

            test.setAge(age);
            test.setName(test.getName());
            studentRepo.save(test);
        } else
            throw new RuntimeException();


        return "update shod";
    }

    @Override
    public String deleteStudent(Long id) {

//        for (Student std : list) {
//            if (std.getId() == id) {
//                list.remove(std);
//                break;
//
//            }
//
//
//        }

        return "delete shod";
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
