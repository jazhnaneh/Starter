package com.jazhnaneh.student.model;




import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "lesson_table")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id", unique = true)
    private Long lessonId;


    @NotNull
    @NotBlank
    @Column(name = "title")
    @NotEmpty(message = "title is required")
    private String title;





    @Column(name = "CREATED_AT",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;




    @Column(name = "UPDATE_AT",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idStudent")
    private Student student;


    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }




    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();

    }

    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }

}
