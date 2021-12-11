package ie.adam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int studentId;
    @Column(nullable = false, unique = true)
    String studentEmail;
    @Column(nullable = false)
    String studentFname;
    @Column(nullable = false)
    String studentSurname;
    @OneToMany(mappedBy = "noteStudent", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Note> studentNotes;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentFname='" + studentFname + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                '}';
    }

    public Student(String studentEmail, String studentFname, String studentSurname) {
        this.studentEmail = studentEmail;
        this.studentFname = studentFname;
        this.studentSurname = studentSurname;
    }

}
