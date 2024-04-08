package hw.hw3.userapp.controller;

import hw.hw3.userapp.client.UserRestClient;
import hw.hw3.userapp.entity.Userr;
import hw.hw3.userapp.controller.payload.UpdateUserPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type User controller.
 * контроллер для REST клиента
 * @RequiredArgsConstructor - для полей private final
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("userr/users/{userId:\\d+}")
public class UserController {

    private final UserRestClient userRestClient;

    /**
     * User userr.
     * для метода, который автоматически добавляет возвращаемый им объект (Userr) в модель под ключом "userModel"
     * @param userId the user id
     * @return the userr
     */
    @ModelAttribute("userModel")
    public Userr user(@PathVariable("userId") int userId) {
        return this.userRestClient.findUser(userId).orElseThrow();
    }

    /**
     * Gets user.
     * получает конкретного пользователя user
     * @return the user
     */
    @GetMapping
    public String getUser() {
        return "userr/users/user";
    }

    /**
     * Gets user edit page.
     * отправляет на страницу изменения
     * @return the user edit page
     */
    @GetMapping("edit")
    public String getUserEditPage() {
        return "/userr/users/edit";
    }

    /**
     * Update product string.
     * @ModelAttribute(value = "userModel" - получаем user из @ModelAttribute("userModel")
     * @param user    the user
     * @param payload the payload - DTO объект
     * @return the string
     */
    @PostMapping("edit")
    public String updateProduct(@ModelAttribute(value = "userModel", binding = false) Userr user,
                                @Validated UpdateUserPayload payload) {
        this.userRestClient.updateUser(user.id(), payload.username(), payload.userEmail());
        return "redirect:/userr/users/%d".formatted(user.id());
    }

    /**
     * Delete user string.
     * Удаляем пользователя
     * @param product the product
     * @return the string
     */
    @PostMapping("delete")
    public String deleteUser(@ModelAttribute("userModel") Userr product) {

        this.userRestClient.deleteUser(product.id());
        return "redirect:/userr/users/list";
    }
}
