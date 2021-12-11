package ie.adam;

import ie.adam.entities.Note;
import ie.adam.entities.Student;
import ie.adam.entities.User;
import ie.adam.service.NoteService;
import ie.adam.service.StudentService;
import ie.adam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    NoteService noteService;
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Student student = studentService.addStudent("mary.murphy@mycit.ie", "Mary", "Murphy");
        Student student1 = studentService.addStudent("jane.doe@mycite.ie", "Jane", "Doe");
        Student student2 = studentService.addStudent("richard.jackson@mycit.ie", "Richard", "Jackson");

        Note note = noteService.addNote("note1", student);
        Note note2 = noteService.addNote("This is a longer note to test what the note will look like ", student);
        Note note3 = noteService.addNote("333333", student);
        Note note4 = noteService.addNote("44444", student);
        Note note5 = noteService.addNote("55555", student);
        Note note6 = noteService.addNote("only note for this student", student1);

        User mentorUser = new User("mentor@mtu.ie", passwordEncoder.encode("password"), "MENTOR", "Cliona", "McGuane");
        User reviewerUser = new User("reviewer@mtu.ie", passwordEncoder.encode("password"), "REVIEWER", "John", "Smith");
        User apiUser = new User("api@mtu.ie", passwordEncoder.encode("password"), "API", "Jamie", "Jones");

        userService.save(mentorUser);
        userService.save(reviewerUser);
        userService.save(apiUser);

    }
}
