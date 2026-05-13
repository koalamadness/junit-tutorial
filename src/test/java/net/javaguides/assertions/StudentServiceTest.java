package net.javaguides.assertions;

import net.javaguides.Student;
import net.javaguides.StudentNotFoundException;
import net.javaguides.StudentService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTest() {

        StudentService studentService = new StudentService();

        //Student student = new Student("Ramesh", 2);

        List<Student> listOfStudents = studentService.getStudents();
        //studentService.addStudent(student);

        boolean result = listOfStudents.isEmpty();

        assertTrue(() -> result, "Denied");

    }

    @Disabled
    @Test
    public void getStudentsTestAssertFalse() {

        StudentService studentService = new StudentService();

        //Student student = new Student("Ramesh", 2);

        List<Student> listOfStudents = studentService.getStudents();
        //studentService.addStudent(student);

        boolean result = listOfStudents.isEmpty();

        assertFalse(result);

    }

    @Test
    public void getStudentByIdTest(){
        StudentService studentService = new StudentService();

        Student student = new Student("Ramesh", 1);
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(7);

        assertNull(actualObject);

    }

    @Test
    public void getStudentByIdTestAssertEqual(){
        StudentService studentService = new StudentService();

        Student student = new Student("Ramesh", 1);
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);

        assertEquals(1, actualObject.getId());
        assertEquals("Ramesh", actualObject.getName());
        assertEquals(student, actualObject);
    }

    @Disabled
    @Test
    public void getStudentByNameAssert() {

        StudentService studentService = new StudentService();
        Student student = new Student("Papi", 1);
        studentService.addStudent(student);


        assertThrows(NullPointerException.class, ()-> {
            studentService.getStudentByName("Exc");
        } );

    }

    @Test
    void addStudent() {
    }
}