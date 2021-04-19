package tools.manager.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.manager.models.User;
import tools.manager.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
//@Api("API: User operations")
public class UserController {

    private final UserService userService;

//    @ApiOperation(value = "Create new User")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "User successfully created"),
//            @ApiResponse(code = 400, message = "Invalid User body")
//    })
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userCreated = userService.createUser(user);
        return ResponseEntity.status(200).body(userCreated);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(200).body(userService.findAll());
    }

}
