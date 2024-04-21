package HW.HW4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Userr. Сущность пользователя с
 * @Entity - аннотация springframework сообщающая приложению spring что этот клас - описывает сущьность
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_users", schema = "s_users")
public class Userr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_username")
    private String username;

    @Column(name = "c_user_mail")
    private String userEmail;
}
