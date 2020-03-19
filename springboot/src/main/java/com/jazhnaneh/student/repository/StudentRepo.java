package com.jazhnaneh.student.repository;

import com.jazhnaneh.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;
import java.util.Optional;

public interface StudentRepo extends PagingAndSortingRepository<Student, Long>,QuerydslPredicateExecutor<Student> {

    Optional<Student> findById(Long id);

    Optional<Student> findByName(String name);

    Optional<Student> findByNationalCode(String nationalCode);

    Optional<Student> findByPhoneNumber(String phoneNumber);

    List<Student> findAllByAge(Integer age);

    List<Student> findAll();

    Page<Student> findAll(Pageable pageable);

}
