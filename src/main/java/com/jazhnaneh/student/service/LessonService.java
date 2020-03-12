package com.jazhnaneh.student.service;

import com.jazhnaneh.student.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAll();

    Lesson  addLesson(Lesson lesson,Long studentId);


    List<Lesson> getAll(Long id );

}
