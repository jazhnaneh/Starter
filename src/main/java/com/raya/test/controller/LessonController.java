package com.raya.test.controller;


import com.raya.test.model.Lesson;
import com.raya.test.service.LessonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    LessonServiceImpl lessonService;


    @GetMapping("/getAll")
    public List<Lesson> getAllData() {

        return lessonService.getAll();
    }

//    @GetMapping("/updateStudent/{name}/{age}")
//    public String updateStudent(@PathVariable("name") String name,@PathVariable("age") int age){
//
//        return studentService.updateStudent(name,age);
//    }


    @GetMapping("/getAllByStudent/{id}")
    public List<Lesson> getAll(@PathVariable("id") Long id) {

        return lessonService.getAll(id);

    }


    @PostMapping("/addLesson")
    public ResponseEntity<Void> addStudent(@RequestBody Map<String, Object> data) {
        Long parentId = ((Number) data.get("parentId")).longValue();
        String title = (String) data.get("title");

        Lesson lesson = new Lesson();
        lesson.setTitle(title);
        lessonService.addLesson(lesson, parentId);

        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }


}
