package hw.hw6userservice.entity;


import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Userr.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "s_users", name = "t_users")
public class Userr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_username")
    private String username;

    @Column(name = "c_user_mail")
    private String userEmail;
}
