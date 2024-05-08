package hw.hw6userservice.controller;

import hw.hw6userservice.dto_service.UpdateUserPayload;
import hw.hw6userservice.entity.Userr;
import hw.hw6userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type User rest controller. REST Controller для user
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("userr-api/users/{userId:\\d+}")// не может быть передана случайная строка, не соответствующая формату числа
public class UserRestController {

    private final UserService userService;

    /**
     * Gets user.
     * получает user и потом его используем в других методах
     * @param userId the user id
     * @return the user
     */
    @ModelAttribute("userModel")
    public Userr getUser(@PathVariable("userId") int userId) {

        return this.userService.findUser(userId).orElseThrow();
    }

    /**
     * Find user userr.
     *
     * @param userModel the user model
     * @return the userr
     */
    @GetMapping
    public Userr findUser(@ModelAttribute("userModel") Userr userModel) {
        return userModel;
    }

    /**
     * Update user response entity.
     *
     * @param userId  the user id
     * @param payload the payload
     * @return the response entity
     */
    @PatchMapping
    public ResponseEntity<?> updateUser(@PathVariable("userId") int userId,
                                           @RequestBody UpdateUserPayload payload) {

        this.userService.updateUser(userId, payload.username(), payload.userEmail());
        return ResponseEntity.noContent()
                .build();
    }

    /**
     * Delete user response entity.
     *
     * @param userId the user id
     * @return the response entity
     */
    @DeleteMapping
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
