package HW.HW2.controller.repository;

import HW.HW2.entity.Userr;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryCRUD extends CrudRepository<Userr, Integer> {
}
