package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/create")

    public String createNewUser() {
        User user = new User();
        user.setEmail("duc30092005@gmail.com");
        user.setName("Duc Thanh Nguyen");
        user.setPassword("123345");
        this.userService.handleCreateUser(user);
        return "New User Created";
    }
}
