package com.jazhnaneh.starter.service;

import com.jazhnaneh.starter.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAll();

    Lesson  addLesson(Lesson lesson,Long studentId);


    List<Lesson> getAll(Long id );

}
