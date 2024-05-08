package hw.hw6userservice.repository;


import hw.hw6userservice.entity.Userr;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository crud.
 */
public interface UserRepositoryCRUD extends CrudRepository<Userr, Integer> {
}
