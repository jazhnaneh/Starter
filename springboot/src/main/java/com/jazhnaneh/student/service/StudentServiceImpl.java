package com.jazhnaneh.student.service;

import com.jazhnaneh.student.exeption.NotConfirmNationalCodeException;
import com.jazhnaneh.student.exeption.NotConfirmPhoneNumberException;
import com.jazhnaneh.student.exeption.NotFoundException;
import com.jazhnaneh.student.exeption.SaveImageException;
import com.jazhnaneh.student.model.Student;
import com.jazhnaneh.student.repository.StudentRepo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
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

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student addStudent(Student student, MultipartFile file) {

//        Optional<Student> byNationalCode = studentRepo.findByNationalCode(student.getNationalCode());
//        Optional<Student> byPhoneNumber = studentRepo.findByPhoneNumber(student.getPhoneNumber());

        try {
            student.setImageName(file.getOriginalFilename());
            student.setImageType(file.getContentType());
            student.setImage(IOUtils.toByteArray(file.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
            throw new SaveImageException(e.getMessage());
        }

        if (student.getPhoneNumber().length() != 11)
            throw new NotConfirmPhoneNumberException("شماره موبایل باید 11 رقم باشد");
        else if (student.getNationalCode().length() != 10)
            throw new NotConfirmNationalCodeException("کد ملی باید 10 رقم باشد");
      /*  else if (byNationalCode.isPresent())
            throw new NotConfirmNationalCodeException("کد ملی در سیستم موجود می باشد");
        else if (byPhoneNumber.isPresent())
            throw new NotConfirmPhoneNumberException("کد ملی در سیستم موجود می باشد");*/


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
    public String updateStudent(Long id, Student student) {

        Optional<Student> studentSearch = studentRepo.findById(id);

        if (studentSearch.isPresent()) {

            Student studentUpdate = studentSearch.get();

            studentUpdate.setAge(student.getAge());
            studentUpdate.setName(student.getName());
            studentRepo.save(studentUpdate);
        } else {
            throw new RuntimeException();
        }

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

    @Override
    public List<Student> filter(int page, int pageSize, String studentName, String studentFamily, Integer age) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
//        QStudent qStudent= QStudent.student;
//        if (studentName != null && !studentName.isEmpty()) {
//            booleanBuilder.and(qStudent.name.eq(studentName));
//        }
//
//        if (studentFamily != null && !studentFamily.isEmpty()) {
//            booleanBuilder.and(qStudent.family.eq(studentFamily));
//        }
//
//        if (age != null && age != 0) {
//            booleanBuilder.and(qStudent.age.goe(age));
//        }
//


        Page<Student> page1 = studentRepo.findAll(booleanBuilder.getValue(),
                PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "idStudent")));

        return page1.getContent();
    }

    @Override
    public List<Student> simplifiedFilter(int page, int pageSize, Predicate predicate) {
        Page<Student> page1 = studentRepo.findAll(predicate,
                PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "idStudent")));

        return page1.getContent();
    }
}
