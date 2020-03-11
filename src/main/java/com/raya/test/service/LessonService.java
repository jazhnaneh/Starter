package com.raya.test.service;

import com.raya.test.model.Lesson;
import com.raya.test.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LessonService {

    List<Lesson> getAll();

    Lesson  addLesson(Lesson lesson,Long studentId);


    List<Lesson> getAll(Long id );

}
