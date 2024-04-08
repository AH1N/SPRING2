package hw.hw3.userservice.controller;

import hw.hw3.userservice.controller.payload.NewUserPayload;
import hw.hw3.userservice.entity.Userr;
import hw.hw3.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

/**
 * The type Users rest controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("userr-api/users")
public class UsersRestController {

    private final UserService userService;

    /**
     * Gets user list.
     *
     * @return the user list
     */
    @GetMapping
    public Iterable<Userr> getUserList() {

        return this.userService.findAllUsers();
    }

    /**
     * Create user response entity.
     *
     * @param payload              the payload
     * @param uriComponentsBuilder the uri components builder
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody NewUserPayload payload, UriComponentsBuilder uriComponentsBuilder) { //добавляем модель, чтобы потом её заполнить данными
        Userr user = this.userService.createUser(payload.username(), payload.userEmail());
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/userr-api/users/{userId}")
                        .build(Map.of("userId", user.getId())))
                .body(user);
    }
}
