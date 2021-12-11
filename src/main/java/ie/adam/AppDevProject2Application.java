package ie.adam;

import ie.adam.dao.NoteDao;
import ie.adam.dao.StudentDao;
import ie.adam.dao.UserDao;
import ie.adam.entities.Note;
import ie.adam.entities.Student;
import ie.adam.entities.User;
import ie.adam.service.NoteService;
import ie.adam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AppDevProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(AppDevProject2Application.class, args);
	}

}
