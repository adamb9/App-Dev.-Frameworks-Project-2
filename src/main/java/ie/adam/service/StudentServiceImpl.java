package ie.adam.service;

import ie.adam.dao.NoteDao;
import ie.adam.dao.StudentDao;
import ie.adam.entities.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    NoteDao noteDao;

    @Override
    public Student addStudent(String studentEmail, String studentFname, String studentSurname) {
        if (studentDao.existsByStudentEmail(studentEmail)) {
            return null;
        }
        Student student = new Student(studentEmail, studentFname, studentSurname);
        return studentDao.save(student);
    }

    @Override
    public int deleteStudent(int studentId) {
        if (studentDao.existsByStudentId(studentId)) {
            studentDao.deleteById(studentId);
            return 1;
        }
        return 0;
    }

    @Override
    public Student findStudentByStudentId(int studentId) {
        return studentDao.findByStudentId(studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public List<Student> findStudentsWithNoNotes() {
        return studentDao.findAllByStudentNotesIsNull();
    }

    @Override
    public List<Student> findStudentsWithOver4Notes() {
        return studentDao.findAllByCountStudentNotesGreaterThan(4);
    }

    @Override
    public long findCountOfStudents() {
        return studentDao.count();
    }

    @Override
    public long findAvgNotesPerStudent() {
        return noteDao.count()/studentDao.count();
    }
}
