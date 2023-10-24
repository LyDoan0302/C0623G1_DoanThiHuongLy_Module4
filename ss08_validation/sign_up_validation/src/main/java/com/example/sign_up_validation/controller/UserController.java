package com.example.sign_up_validation.controller;

import com.example.sign_up_validation.model.User;
import com.example.sign_up_validation.model.UserDto;
import com.example.sign_up_validation.service.IUserService;
import com.ibm.j9ddr.vm29.pointer.generated.__sbufPointer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String showUserList(@PageableDefault(value = 2, sort="firstName",
            direction = Sort.Direction.ASC)Pageable pageable, Model model) {
        model.addAttribute("userList", userService.findAll(pageable));
        return "index";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("userDto",new UserDto());
        return "create";
    }
    @PostMapping("/create")
    public String createUser(@Validated
                             @ModelAttribute("userDto") UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "create";
        } else{
            User user = new User();
            BeanUtils.copyProperties(userDto, user);

            userService.save(user);
            redirectAttributes.addFlashAttribute("message",
                    "Create user: " + user.getFirstName() + " "
                            + user.getLastName() + " OK!");
            return "redirect:/";
        }
    }
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id){
        userService.remove(id);
        return "redirect:/";
    }

}
