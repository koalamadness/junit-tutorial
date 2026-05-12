package net.javaguides;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int studentId) {
        return students.stream()
                .filter((student) -> student.getId() == studentId)
                .findFirst()
                .orElse(null);
    }

    public Student getStudentByName(String name) {
        return students.stream()
                .filter((student) -> student.getName().equals(name))
                .findFirst()
                .orElseThrow(()-> new StudentNotFoundException("Student not found with name: " + name));
    }

}