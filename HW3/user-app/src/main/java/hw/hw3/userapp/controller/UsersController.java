package hw.hw3.userapp.controller;

import hw.hw3.userapp.client.UserRestClient;
import hw.hw3.userapp.entity.Userr;
import hw.hw3.userapp.controller.payload.NewUserPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
    public String getUserList(Model model) {
        model.addAttribute("users", this.userRestClient.findAllUsers());
        return "userr/users/list";
    }

    /**
     * Gets new user page.
     * на страницу нового пользователя
     * @return the new user page
     */
    @GetMapping("create")
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
    public String createUser(NewUserPayload payload, Model model) { //добавляем модель, чтобы потом её заполнить данными
        Userr user = this.userRestClient.createUser(payload.username(), payload.userEmail());
        return "redirect:/userr/users/%d".formatted(user.id());
    }
}
