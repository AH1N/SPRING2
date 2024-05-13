package hw.hw6userservice.service;

import hw.hw6userservice.entity.Userr;

import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Find user optional.
     *
     * @param userId the user id
     * @return the optional
     */
    Optional<Userr> findUser(int userId);

    /**
     * Find all users iterable.
     *
     * @return the iterable
     */
    Iterable<Userr> findAllUsers();

    /**
     * Create user userr.
     *
     * @param username the username
     * @param s        the s
     * @return the userr
     */
    Userr createUser(String username, String s);

    /**
     * Update user.
     *
     * @param id       the id
     * @param username the username
     * @param s        the s
     */
    void updateUser(Integer id, String username, String s);

    /**
     * Delete user.
     *
     * @param id the id
     */
    void deleteUser(Integer id);
}
