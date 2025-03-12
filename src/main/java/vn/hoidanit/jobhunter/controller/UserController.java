package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("/user/create")
    @PostMapping("/user")

    public User createNewUser(@RequestBody User postmanUser) {
        User newuser = this.userService.handleCreateUser(postmanUser);
        return newuser;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
    }

    @GetMapping("/user/{id}")
    public User getUserByID(@PathVariable("id") long id) {
        return this.userService.getUserByID(id);
        // return "get user";
    }

    @GetMapping("/user")
    public List<User> findAllUsers() {
        return this.userService.getAllUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }

}
