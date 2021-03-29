package tools.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.manager.models.User;
import tools.manager.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    User createUser(@RequestBody User user){
        return userService.save(user);
    }
}
