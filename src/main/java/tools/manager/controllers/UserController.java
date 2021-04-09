package tools.manager.controllers;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tools.manager.models.User;
import tools.manager.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    User login(@RequestBody User user){
        return null;
    }

    @PostMapping
    void register(@RequestBody User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.save(user);
    }

    @GetMapping
    List<User> findAll(){
        return userService.findAll();
    }
}
