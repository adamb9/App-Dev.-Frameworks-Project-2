package ie.adam.controlers;

import ie.adam.entities.Note;
import ie.adam.entities.Student;
import ie.adam.forms.NewStudentForm;
import ie.adam.forms.SearchStudentForm;
import ie.adam.service.NoteService;
import ie.adam.service.StudentService;
import ie.adam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SearchStudentControllers {

    @Autowired
    NoteService noteService;
    @Autowired
    StudentService studentService;

    @GetMapping("/student/")
    public String showStudentByStudentId(@Valid SearchStudentForm searchStudentForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()){
            return "index";
        }
        Student student = studentService.findStudentByStudentId(searchStudentForm.getStudentId());
        if(student == null) {
            model.addAttribute("studentId", searchStudentForm.getStudentId());
            return "notfounderror";
        }
        List<Note> notes = student.getStudentNotes();
        model.addAttribute("student", student);
        model.addAttribute("notes", notes);
        return "student";
    }


}
