package ie.adam.controlers;

import ie.adam.forms.SearchStudentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexControllers {

    @GetMapping("/")
    public String index(Model model){
        SearchStudentForm searchStudentForm = new SearchStudentForm();
        model.addAttribute("searchStudentForm", searchStudentForm);
        return "index";
    }

    @PostMapping("/")
    public String indexPost(){
        return "index";
    }

    @GetMapping("/403")
    public String notAuthorised()
    {
        return "403";
    }

}
