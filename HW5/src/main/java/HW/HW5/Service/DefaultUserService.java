package HW.HW5.Service;

import HW.HW5.repository.UserRepositoryCRUD;
import HW.HW5.entity.Userr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The type Default user service.
 * Реализация интерфейса UserService
 */
@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepositoryCRUD userRepositoryCRUD;

    @Override
    public Optional<Userr> findUser(int userId) {

        return this.userRepositoryCRUD.findById(userId);
    }

    @Override
    public List<Userr> findAllUsers() {
        return (List<Userr>) this.userRepositoryCRUD.findAll();
    }

    @Override
    public Userr createUser(String username, String userEmail) {
        return this.userRepositoryCRUD.save(new Userr(null, username, userEmail));
    }

    @Override
    public void updateUser(Integer id, String username, String userEmail) {
        this.userRepositoryCRUD.findById(id)
            .ifPresentOrElse(user -> {
                user.setUsername(username);
                user.setUserEmail(userEmail);
                this.userRepositoryCRUD.save(user);
            }, () ->{
                throw new NoSuchElementException();
            });
    }

    @Override
    public void deleteUser(Integer id) {
        this.userRepositoryCRUD.deleteById(id);
    }
}
