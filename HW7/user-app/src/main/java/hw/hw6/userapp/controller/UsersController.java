package hw.hw6.userapp.controller;

import hw.hw6.userapp.client.UserRestClient;
import hw.hw6.userapp.entity.Userr;
import hw.hw6.userapp.dto_userapp.NewUserPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Users controller. ДЛЯ списка и всй ветки списка
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("userr/users")
public class UsersController {

    private final UserRestClient userRestClient;

    /**
     * Gets user list.
     *
     * @param model the model
     * @return the user list
     */
    @GetMapping("list")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') && hasAuthority('ROLE_USER')")
    public String getUserList(Model model) {
        model.addAttribute("users", this.userRestClient.findAllUsers());
        return "userr/users/list";
    }

    @GetMapping("welcome")
    public String getWelcomePage() {
        return "userr/users/welcome";
    }

    @GetMapping("cat")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getCatPage() {
        return "userr/users/cat";
    }
    /**
     * Gets new user page.
     * на страницу нового пользователя
     * @return the new user page
     */
    @GetMapping("create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') && hasAuthority('ROLE_USER')")
    public String getNewUserPage() {
        return "userr/users/new_user";
    }

    /**
     * Create user string.
     * создание пользователя
     * @param payload the payload DTO объект
     * @param model   the model
     * @return the string
     */

    @PostMapping("create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') && hasAuthority('ROLE_USER')")
    public String createUser(NewUserPayload payload, Model model) { //добавляем модель, чтобы потом её заполнить данными
        Userr user = this.userRestClient.createUser(payload.username(), payload.userEmail());
        return "redirect:/userr/users/%d".formatted(user.id());
    }
}
