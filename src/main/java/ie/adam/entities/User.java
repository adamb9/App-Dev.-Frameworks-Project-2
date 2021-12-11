package ie.adam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @Column(nullable = false, unique = true)
    String userEmail;
    @Column(nullable = false)
    String userPassword;
    @Column(nullable = false)
    String userRole;
    @Column(nullable = false)
    String userFname;
    @Column(nullable = false)
    String userSurname;

}
