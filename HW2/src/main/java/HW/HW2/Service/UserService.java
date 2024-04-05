package HW.HW2.Service;

import HW.HW2.entity.Userr;

import java.util.List;
import java.util.Optional;

public interface UserService {


    Optional<Userr> findUser(int userId);

    List<Userr> findAllUsers();

    Userr createUser(String username, String s);

    void updateUser(Integer id, String username, String s);

    void deleteUser(Integer id);

}
