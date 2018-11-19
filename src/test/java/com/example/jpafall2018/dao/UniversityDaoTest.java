package com.example.jpafall2018.dao;

import com.example.jpafall2018.models.*;
import com.example.jpafall2018.repositories.FacultyRepository;
import com.example.jpafall2018.repositories.UserRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UniversityDaoTest {

    private static final String PASSWORD = "password";
    @Autowired
    private FacultyRepository facultyRepository;


    //faculty creation

    Faculty facultyAlan = new Faculty("alan",PASSWORD,"Alan","Turin","123A", true);
    Faculty facultyAda = new Faculty("ada",PASSWORD,"Ada","Lovelace","123B", true);


    Student studentALice = new Student("alice",PASSWORD,"Alice","Wonderland",2020, (long) 12000);
    Student studentBob = new Student("bob",PASSWORD,"Bob","Hope",2021, (long) 23000);
    Student studentCharlie = new Student("bob",PASSWORD,"Charlie","Brown",2019, (long) 21000);
    Student studentDan = new Student("dan",PASSWORD,"Dan","Craig",2019, (long) 0);
    Student studentEdward = new Student("edward",PASSWORD,"Edward","Scissorhands",2022, (long) 11000);
    Student studentFrank = new Student("frank",PASSWORD,"Frank","Herbert",2018, (long) 0);
    Student studentGregory = new Student("gregory",PASSWORD,"Gregory","Peck",2023, (long) 10000);


    Course courseCS1234 = new Course("CS1234",null);
    Course courseCS2345 = new Course("CS2345", null);
    Course courseCS3456= new Course("CS3456", null);
    Course courseCS4567= new Course("CS4567", null);


    Section sec4321 = new Section("SEC4321", 50);
    Section sec5432 = new Section("SEC5432", 50);
    Section sec6543 = new Section("SEC6543", 50);
    Section sec7654 = new Section("SEC7654", 50);





    @Autowired
    UniversityDao ud;


    @Test
    public void test_000_create_all_records(){

        ud.truncateDatabase();



        ud.createFaculty(facultyAlan);
        ud.createFaculty(facultyAda);

        ud.createStudent(studentALice);
        ud.createStudent(studentBob);
        ud.createStudent(studentCharlie);
        ud.createStudent(studentDan);
        ud.createStudent(studentEdward);
        ud.createStudent(studentFrank);
        ud.createStudent(studentGregory);



        ud.createCourse(courseCS1234);
        ud.createCourse(courseCS2345);
        ud.createCourse(courseCS3456);
        ud.createCourse(courseCS4567);


        ud.createSection(sec4321);
        ud.createSection(sec6543);
        ud.createSection(sec5432);
        ud.createSection(sec7654);



//        SEC4321 50 CS1234
//        SEC5432 50 CS1234
//        SEC6543 50 CS2345
//        SEC7654 50 CS3456


        ud.addSectionToCourse(sec4321 , courseCS1234);
        ud.addSectionToCourse(sec5432 , courseCS1234);
        ud.addSectionToCourse(sec6543 , courseCS2345);
        ud.addSectionToCourse(sec7654 , courseCS3456);

//
        ud.enrollStudentInSection(studentALice,     sec4321);
        ud.enrollStudentInSection(studentALice,     sec5432);
        ud.enrollStudentInSection(studentBob,       sec5432);
        ud.enrollStudentInSection(studentCharlie,   sec6543);


//
//        CS1234 Alan
//        CS2345 Alan
//        CS3456 Ada
//        CS4567 Ada

        ud.setAuthorForCourse(facultyAlan,  courseCS1234);
        ud.setAuthorForCourse(facultyAlan,  courseCS2345);
        ud.setAuthorForCourse(facultyAda,   courseCS3456);
        ud.setAuthorForCourse(facultyAda,   courseCS4567);
//





    }

//    Validates uses - write a test that validates the total number of users

    @Test
    public void test_01_validate_all_users() {


        assertEquals(9, ud.findAllUsers().size());

    }

//    Validates faculty - write a test that validates the total number of faculty
        @Test
    public  void  test_02_validate_all_faculties(){

            assertEquals(2, ud.findAllFaculty().size());
        }


//    Validates students - write a test that validates the total number of students

    @Test
    public  void  test_03_validate_all_students(){

        assertEquals(7, ud.findAllStudents().size());
    }



//    Validates courses - write a test that validates the total number of courses

    @Test
    public  void  test_04_validate_all_courses(){

        assertEquals(4, ud.findAllCourses().size());
    }




//    Validates sections - write a test that validates the total number of sections


    @Test
    public  void  test_05_validate_all_sections(){

        assertEquals(4, ud.findAllSections().size());
    }


//   Validates Course authorship - write a test that validates
// the total number of courses authored by each faculty

    @Test
    public  void  test_06_validate_all_section(){

        assertEquals(4, ud.findAllSections().size());
    }




}
