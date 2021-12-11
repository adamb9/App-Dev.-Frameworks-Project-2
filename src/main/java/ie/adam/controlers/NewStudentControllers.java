package ie.adam.controlers;

import ie.adam.entities.Student;
import ie.adam.forms.NewStudentForm;
import ie.adam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class NewStudentControllers {
    @Autowired
    StudentService studentService;

    @GetMapping("/newstudent")
    public String addStudent(Model model) {
        NewStudentForm studentForm = new NewStudentForm();
        model.addAttribute("newStudentForm", studentForm);
        return "newstudent";
    }

    @PostMapping("/newstudent")
    public String addStudentPost(@Valid NewStudentForm newStudentForm, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "newstudent";
        }
        Student student = studentService.addStudent(
                newStudentForm.getEmail(),
                newStudentForm.getFirstName(),
                newStudentForm.getLastName()
        );
        if(student == null) {
            redirectAttributes.addFlashAttribute("duplicateStudentEmail", true);
            return "redirect:newstudent";
        }
        return "redirect:student/" + student.getStudentId();
    }
}
