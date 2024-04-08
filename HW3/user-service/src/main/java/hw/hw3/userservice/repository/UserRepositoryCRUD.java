package hw.hw3.userservice.repository;


import hw.hw3.userservice.entity.Userr;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository crud.
 */
public interface UserRepositoryCRUD extends CrudRepository<Userr, Integer> {
}
