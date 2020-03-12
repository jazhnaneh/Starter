package com.jazhnaneh.student.service;

import com.jazhnaneh.student.model.Student;
import com.jazhnaneh.student.model.Lesson;
import com.jazhnaneh.student.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
