package ie.adam.dao;

import ie.adam.entities.Note;
import ie.adam.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer> {

    boolean existsByStudentEmail(String studentEmail);

    boolean existsByStudentId(int studentId);

    Student findByStudentId(int studentId);

    List<Student> findAllByStudentNotesIsNull();

    @Query("select s from Student s where s.studentNotes.size > :noNotes ")
    List<Student> findAllByCountStudentNotesGreaterThan(@Param("noNotes") int noNotes);

}
