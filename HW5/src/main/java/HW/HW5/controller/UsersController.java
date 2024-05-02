package HW.HW5.controller;

import HW.HW5.Service.UserService;
import HW.HW5.DTO.NewUserPayload;
import HW.HW5.entity.Userr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Users controller.
 * @Controller - Аннотация Spring, что данный класс является контроллером для spring приложения
 *  @RequiredArgsConstructor аннотация (в данном случае) для  private final UserService userService
 *  этот контроллер работает со списким пользователей
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("userr/users")
public class UsersController {
    /**
     * поле для обращения к экземпляру UserService
     * */
    private final UserService userService;

    /**
     * Get user list string.
     * Метод для того чтобы можно было везде использовать готового пользователя, а не постоянно вызывать
     * @param model the model
     * @return the string список пользователей
     */
    @GetMapping("list")
    public String getUserList(Model model){
        model.addAttribute("users", this.userService.findAllUsers());
        return "userr/users/list";
    }
    /**
     * Get new user page string.
     * отправляет на страницу создания нового пользователя
     * @return the string
     */
    @GetMapping("create")
    public String getNewUserPage(){
        return "userr/users/new_user";
    }

    /**
     * Create user string.
     *
     * @param payload the payload - данные с которыми будем создавать нового пользователя
     * @param model   the model
     * @return the string
     */
    @PostMapping("create")
    public String createUser(@Validated NewUserPayload payload, Model model){ //добавляем модель, чтобы потом её заполнить данными
            Userr user = this.userService.createUser(payload.username(), payload.userEmail());
            return "redirect:/userr/users/%d".formatted(user.getId());
    }

}


