package ie.adam.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class SearchStudentForm {
    @NotNull
    @Positive
    private int studentId;
}
