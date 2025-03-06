package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import vn.hoidanit.jobhunter.domain.User;

@RestController
public class UserController {

    @GetMapping("/user/create")

    public String createNewUser() {
        User user = new User();
        user.setEmail("duc30092005@gmail.com");
        user.setName("Duc Thanh Nguyen");
        user.setPasssword("123345");
        return "New User Created";
    }
}
