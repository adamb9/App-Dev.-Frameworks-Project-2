package ie.adam.service;

import ie.adam.entities.Note;
import ie.adam.entities.Student;

import java.util.List;

public interface NoteService {

    Note addNote(String noteText, Student student);

    List<Note> findNotesByStudentId(int studentId);

    int findAvgNotesPerStudent();
}
