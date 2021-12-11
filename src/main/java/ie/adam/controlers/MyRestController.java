package ie.adam.controlers;

import ie.adam.entities.Note;
import ie.adam.entities.Student;
import ie.adam.service.NoteService;
import ie.adam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("myapi")
public class MyRestController {
    @Autowired
    StudentService studentService;

    @Autowired
    NoteService noteService;

    @GetMapping("/notesforstudent/{studentId}")
    ResponseEntity<List<Note>> getNotesForStudent(@PathVariable(name="studentId") int studentId) {
        Student student = studentService.findStudentByStudentId(studentId);
        if(student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(noteService.findNotesByStudentId(studentId), HttpStatus.FOUND);
    }

    @DeleteMapping("/student/{studentId}")
    ResponseEntity<Student> deleteStudent(@PathVariable(name="studentId") int studentId) {
        int status = studentService.deleteStudent(studentId);
        if(status == 1) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
