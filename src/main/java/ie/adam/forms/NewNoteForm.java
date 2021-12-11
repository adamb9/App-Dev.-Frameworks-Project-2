package ie.adam.forms;

import ie.adam.entities.Student;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NewNoteForm {
    @Size(min=1, max=200)
    private String noteText;
    @NotNull
    private int studentId;
}
