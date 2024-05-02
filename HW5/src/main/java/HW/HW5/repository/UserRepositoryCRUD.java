package HW.HW5.repository;

import HW.HW5.entity.Userr;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository crud.
 * интерфейс для взаимодействия приложения с базой данных
 */
public interface UserRepositoryCRUD extends CrudRepository<Userr, Integer> {
}
