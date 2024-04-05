package HW.HW2.controller;

import HW.HW2.Service.UserService;
import HW.HW2.controller.payload.UpdateUserPayload;
import HW.HW2.entity.Userr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("userr/users/{userId:\\d+}")
public class UserController {

    private final UserService userService;

    @ModelAttribute("userModel")
    public Userr user(@PathVariable("userId") int userId){
        return this.userService.findUser(userId).orElseThrow();
    }

    @GetMapping
    public String getUser(){
        return "userr/users/user";
    }

    @GetMapping("edit")
    public String getUserEditPage(){
        return "/userr/users/edit";
    }

    @PostMapping("edit")
    public String updateProduct(@ModelAttribute(value = "userModel", binding = false) Userr user,
                                @Validated UpdateUserPayload payload){
        this.userService.updateUser(user.getId(), payload.username(), payload.userEmail());
        return "redirect:/userr/users/%d".formatted(user.getId());
    }

    @PostMapping("delete")
    public String deleteUser(@ModelAttribute("userModel") Userr product){

        this.userService.deleteUser(product.getId());
        return "redirect:/userr/users/list";
    }
}
