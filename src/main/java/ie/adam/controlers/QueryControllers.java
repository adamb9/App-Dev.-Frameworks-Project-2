package ie.adam.controlers;

import ie.adam.entities.Note;
import ie.adam.entities.Student;
import ie.adam.service.NoteService;
import ie.adam.service.StudentService;
import ie.adam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QueryControllers {
    @Autowired
    NoteService noteService;
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    @GetMapping("/allstudents")
    public String allStudents(Model model) {
        model.addAttribute("allstudents", studentService.findAllStudents());
        return "allstudents";
    }

    @GetMapping("/allstudents/nonote")
    public String noNoteStudents(Model model) {
        model.addAttribute("noNoteStudents", studentService.findStudentsWithNoNotes());
        return "nonotestudents";
    }

    @GetMapping("/allstudents/over4notes")
    public String over4NoteStudents(Model model) {
        model.addAttribute("over4NoteStudents", studentService.findStudentsWithOver4Notes());
        return "morethan4notestudents";
    }

    @GetMapping("/student/{studentId}")
    public String showStudentByStudentId(@PathVariable("studentId") int studentId, Model model) {
        Student student = studentService.findStudentByStudentId(studentId);
        if(student == null) {
            model.addAttribute("studentId", studentId);
            return "notfounderror";
        }
        List<Note> notes = student.getStudentNotes();
        model.addAttribute("student", student);
        model.addAttribute("notes", notes);
        return "student";
    }

    @GetMapping("/stats")
    public String showStats(Model model) {
        model.addAttribute("noStudents", studentService.findCountOfStudents());
        model.addAttribute("avgNotes", studentService.findAvgNotesPerStudent());
        return "stats";
    }

}
