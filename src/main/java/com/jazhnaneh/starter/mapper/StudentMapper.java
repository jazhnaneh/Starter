package com.jazhnaneh.starter.mapper;

import com.jazhnaneh.starter.model.Student;
import com.jazhnaneh.starter.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "idStudent", target = "studentId")
    @Mapping(source = "imageName", target = "studentImageName")
    @Mapping(source = "imageType", target = "studentImageType")
    @Mapping(source = "name", target = "studentName")
    @Mapping(source = "age", target = "studentAge", qualifiedByName = "convertToStringAge")
    @Mapping(source = "image", target = "studentImage")
    StudentDTO toStudentDTO(Student student);


    @Mapping(source = "studentId", target = "idStudent")
    @Mapping(source = "studentImageType", target = "imageName")
    @Mapping(source = "studentImageName", target = "imageType")
    @Mapping(source = "studentName", target = "name")
    @Mapping(source = "studentAge", target = "age", qualifiedByName = "convertToIntegerAge")
    @Mapping(source = "studentImage", target = "image")
    Student toStudentEntity(StudentDTO studentDTO);

    List<StudentDTO> toStudentsDTO(Page<Student> userList);

    List<StudentDTO> toStudentsDTO(List<Student> userList);

    @Named("convertToIntegerAge")
    default int convertToIntegerAge(String age) {
        return Integer.parseInt(age);
    }


    @Named("convertToStringAge")
    default String convertToStringAge(int age) {
        return String.valueOf(age);
    }
}
