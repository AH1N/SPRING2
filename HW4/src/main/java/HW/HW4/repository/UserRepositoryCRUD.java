package HW.HW4.repository;

import HW.HW4.entity.Userr;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository crud.
 * интерфейс для взаимодействия приложения с базой данных
 */
public interface UserRepositoryCRUD extends CrudRepository<Userr, Integer> {
}
