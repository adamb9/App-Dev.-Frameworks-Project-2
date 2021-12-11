package ie.adam.service;

import ie.adam.entities.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(String studentEmail, String studentFname, String studentSurname);

    int deleteStudent(int studentId);

    Student findStudentByStudentId(int studentId);

    List<Student> findAllStudents();

    List<Student> findStudentsWithNoNotes();

    List<Student> findStudentsWithOver4Notes();

    long findCountOfStudents();

    long findAvgNotesPerStudent();
}
