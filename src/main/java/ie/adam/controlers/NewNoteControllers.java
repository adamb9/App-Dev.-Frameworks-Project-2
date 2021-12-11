package ie.adam.controlers;

import ie.adam.entities.Note;
import ie.adam.entities.Student;
import ie.adam.forms.NewNoteForm;
import ie.adam.service.NoteService;
import ie.adam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NewNoteControllers {
    @Autowired
    NoteService noteService;
    @Autowired
    StudentService studentService;

    @GetMapping("/newnote")
    public String addNote(Model model) {
        NewNoteForm newNoteForm = new NewNoteForm();
        model.addAttribute("newNoteForm", newNoteForm);
        model.addAttribute("studentList", studentService.findAllStudents());
        return "newnote";
    }

    @PostMapping("/newnote")
    public String addNotePost(Model model, @Valid NewNoteForm newNoteForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("studentList", studentService.findAllStudents());
            return "newnote";
        }
        Student student = studentService.findStudentByStudentId(newNoteForm.getStudentId());
        Note note = noteService.addNote(newNoteForm.getNoteText(), student);

        return "redirect:student/" + note.getNoteStudent().getStudentId();
    }

}
