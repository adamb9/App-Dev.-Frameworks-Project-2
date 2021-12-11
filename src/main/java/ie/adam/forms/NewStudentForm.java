package ie.adam.forms;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NewStudentForm {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min=1, max=30)
    private String firstName;
    @NotNull
    @Size(min=1, max=30)
    private String lastName;
}
