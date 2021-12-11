package ie.adam.service;

import ie.adam.dao.NoteDao;
import ie.adam.entities.Note;
import ie.adam.entities.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDao noteDao;

    @Override
    public Note addNote(String noteText, Student student) {
        Note note = new Note(new Date(), noteText, student);
        return noteDao.save(note);
    }

    @Override
    public List<Note> findNotesByStudentId(int studentId) {
        return noteDao.findAllByNoteStudent_StudentId(studentId);
    }

    @Override
    public int findAvgNotesPerStudent() {
        return 0;
    }
}
