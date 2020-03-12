package com.jazhnaneh.starter.repository;

import com.jazhnaneh.starter.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {

    Optional<Student> findById(Long id);

    Optional<Student> findByName(String name);

    List<Student> findAllByAge(Integer age);

    List<Student> findAll();

    Page<Student> findAll(Pageable pageable);

}
