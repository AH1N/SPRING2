package HW.HW2.controller;

import HW.HW2.Service.UserService;
import HW.HW2.controller.payload.NewUserPayload;
import HW.HW2.entity.Userr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("userr/users")
public class UsersController {

    private final UserService userService;

    @GetMapping("list")
    public String getUserList(Model model){
        model.addAttribute("users", this.userService.findAllUsers());
        return "userr/users/list";
    }

    @GetMapping("create")
    public String getNewUserPage(){
        return "userr/users/new_user";
    }

    @PostMapping("create")
    public String createUser(@Validated NewUserPayload payload, Model model){ //добавляем модель, чтобы потом её заполнить данными
            Userr user = this.userService.createUser(payload.username(), payload.userEmail());
            return "redirect:/userr/users/%d".formatted(user.getId());
    }

//    @GetMapping
//    public String getUser(){
//        return "/userr/users/user";
//    }
}


