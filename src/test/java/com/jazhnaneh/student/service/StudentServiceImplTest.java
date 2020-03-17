package com.jazhnaneh.student.service;

import com.jazhnaneh.student.model.Student;
import com.jazhnaneh.student.repository.StudentRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class StudentServiceImplTest {

    @Autowired
    StudentRepo studentRepo;

    @Test
    public void crudTest() {

        Student s1 = new Student();
        s1.setName("mahdi");
        s1.setFamily("asoodeh");
        s1.setPhoneNumber("09362827111");
        s1.setNationalCode("1234567890");
        s1.setAge(27);
        Student temp1 = studentRepo.save(s1);


        Student s2 = new Student();
        s2.setName("shabab");
        s2.setFamily("koohi");
        s2.setPhoneNumber("09141112233");
        s2.setNationalCode("9876543210");
        s2.setAge(30);
        Student temp2 = studentRepo.save(s2);


        Assert.assertEquals(2, studentRepo.findAll().size());
        Assert.assertTrue(studentRepo.findByName("mahdi").isPresent());
        Assert.assertNotNull(s2.getIdStudent());
        studentRepo.deleteById(temp1.getIdStudent());
        Assert.assertEquals(1, studentRepo.findAll().size());



    }

}