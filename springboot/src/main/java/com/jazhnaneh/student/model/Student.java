package com.jazhnaneh.student.model;


import com.querydsl.core.annotations.QueryEntity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Student")
@QueryEntity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", unique = true)
    private Long idStudent;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "family")
    private String family;

    @NotNull
    @NotBlank
    @Column(name = "phone_umber")
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Column(name = "national_code")
    private String nationalCode;

    @NotNull
    @Column(name = "age")
    private int age;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_type")
    private String imageType;

    @Lob
    @Column(name = "image")

    private byte[] image;


    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Lesson> lessons;


    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UPDATE_AT", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Student() {
    }

    public Student(@NotBlank String name, @NotBlank String family, @NotBlank String phoneNumber, @NotBlank String nationalCode, int age) {
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.age = age;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();

    }

    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + idStudent +
                '}';
    }
}
