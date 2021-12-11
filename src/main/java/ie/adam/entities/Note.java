package ie.adam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int noteId;
    Date noteCreationDate;
    String noteText;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    Student noteStudent;

    public Note(Date noteCreationDate, String noteText, Student noteStudent) {
        this.noteCreationDate = noteCreationDate;
        this.noteText = noteText;
        this.noteStudent = noteStudent;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", noteCreationDate=" + noteCreationDate +
                ", noteText='" + noteText + '\'' +
                '}';
    }

    public Student getNoteStudent() {
        return noteStudent;
    }
}
