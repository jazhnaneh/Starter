package com.jazhnaneh.student.mapper;

import com.jazhnaneh.student.dto.StudentDTO;
import com.jazhnaneh.student.model.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-12T16:07:13+0330",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO toStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentId( student.getIdStudent() );
        studentDTO.setStudentImageType( student.getImageType() );
        studentDTO.setStudentAge( convertToStringAge( student.getAge() ) );
        studentDTO.setStudentImageName( student.getImageName() );
        studentDTO.setStudentName( student.getName() );
        byte[] studentImage = student.getImage();
        if ( studentImage != null ) {
            studentDTO.setStudentImage( Arrays.copyOf( studentImage, studentImage.length ) );
        }

        return studentDTO;
    }

    @Override
    public Student toStudentEntity(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        byte[] image = studentDTO.getStudentImage();
        if ( image != null ) {
            student.setImage( Arrays.copyOf( image, image.length ) );
        }
        student.setImageName( studentDTO.getStudentImageType() );
        student.setName( studentDTO.getStudentName() );
        student.setImageType( studentDTO.getStudentImageName() );
        student.setIdStudent( studentDTO.getStudentId() );
        student.setAge( convertToIntegerAge( studentDTO.getStudentAge() ) );

        return student;
    }

    @Override
    public List<StudentDTO> toStudentsDTO(Page<Student> userList) {
        if ( userList == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>();
        for ( Student student : userList ) {
            list.add( toStudentDTO( student ) );
        }

        return list;
    }

    @Override
    public List<StudentDTO> toStudentsDTO(List<Student> userList) {
        if ( userList == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( userList.size() );
        for ( Student student : userList ) {
            list.add( toStudentDTO( student ) );
        }

        return list;
    }
}
