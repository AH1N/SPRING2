package HW.HW4.controller;

import HW.HW4.Service.UserService;
import HW.HW4.DTO.UpdateUserPayload;
import HW.HW4.entity.Userr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type User controller.
 *
 * @Controller - Аннотация Spring, что данный класс является контроллером для spring приложения
 * @RequiredArgsConstructor аннотация (в данном случае) для  private final UserService userService
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("userr/users/{userId:\\d+}")
public class UserController {
    /**
     * поле для обращения к экземпляру UserService
     * */
    private final UserService userService;

    /**
     * User userr.
     * Метод для того чтобы можно было везде использовать готового пользователя а не постоянно вызывать
     * @param userId the user id
     * @return the userr
     */
    @ModelAttribute("userModel")
    public Userr user(@PathVariable("userId") int userId){
        return this.userService.findUser(userId).orElseThrow();
    }

    /**
     * Get user string.
     * метод GET для получения конкретногго пользователя используя @ModelAttribute("userModel")
     * @return the string
     *
     *http://localhost:8080/userr/users/12
     */
    @GetMapping
    public String getUser(){
        return "userr/users/user";
    }

    /**
     * Get user edit page string.
     * отправляет на страницу изменения пользователя
     * @return the string
     */
    @GetMapping("edit")
    public String getUserEditPage(){
        return "/userr/users/edit";
    }

    /**
     * Update product string.
     * метод POST Изменяет пользователя
     * @param updateUser    the user
     * @param payload the payload
     * @return the string и отправляет на страницу измененногоь пользователя
     */
    @PostMapping("edit")
    public String updateProduct(@ModelAttribute(value = "userModel", binding = false) Userr updateUser,
                                @Validated UpdateUserPayload payload){
        this.userService.updateUser(updateUser.getId(), payload.username(), payload.userEmail());
        return "redirect:/userr/users/%d".formatted(updateUser.getId());
    }

    /**
     * Delete user string.
     * Удаляем пользователя и перенаправляем на страницу списка пользователей
     * @param deletingUser the deletingUser
     * @return the string
     */
    @PostMapping("delete")
    public String deleteUser(@ModelAttribute("userModel") Userr deletingUser){

        this.userService.deleteUser(deletingUser.getId());
        return "redirect:/userr/users/list";
    }
}
