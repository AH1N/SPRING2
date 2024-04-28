package hw.hw6.userapp.client;

import hw.hw6.userapp.entity.Userr;

import java.util.List;
import java.util.Optional;

/**
 * The interface User rest client.
 */
public interface UserRestClient {
    /**
     * Find all users list.
     *
     * @return the list
     */
    List<Userr> findAllUsers();

    /**
     * Create user userr.
     *
     * @param username  the username
     * @param userEmail the user email
     * @return the userr
     */
    Userr createUser(String username, String userEmail);

    /**
     * Find user optional.
     *
     * @param userId the user id
     * @return the optional
     */
    Optional<Userr> findUser(int userId);

    /**
     * Update user.
     *
     * @param userId    the user id
     * @param username  the username
     * @param userEmail the user email
     */
    void updateUser(int userId, String username, String userEmail);

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    void deleteUser(int userId);
}
