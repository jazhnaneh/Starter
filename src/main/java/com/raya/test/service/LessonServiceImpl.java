package com.raya.test.service;

import com.raya.test.model.Lesson;
import com.raya.test.model.Student;
import com.raya.test.repository.LessonRepo;
import com.raya.test.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonRepo lessonRepo;

    @Autowired
    StudentServiceImpl studentService;


    @Override
    public List<Lesson> getAll() {
        return lessonRepo.findAll();
    }

    @Override
    public Lesson addLesson(Lesson lesson, Long studentId) {

        Student student = studentService.getStudent(studentId);

        lesson.setStudent(student);

        Lesson savedLesson = lessonRepo.save(lesson);


        return savedLesson;
    }

    @Override
    public List<Lesson> getAll(Long id ) {

        Student student=studentService.getStudent(id);

        List<Lesson> lessons = lessonRepo.findAllByStudent(student);


        return lessons;
    }
}
