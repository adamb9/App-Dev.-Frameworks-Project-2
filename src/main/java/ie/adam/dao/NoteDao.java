package ie.adam.dao;

import ie.adam.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteDao extends JpaRepository<Note, Integer> {

    List<Note> findAllByNoteStudent_StudentId(int studentId);

}
