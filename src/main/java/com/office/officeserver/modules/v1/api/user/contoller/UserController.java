package com.office.officeserver.modules.v1.api.user.contoller;

import com.office.officeserver.modules.v1.api.user.model.User;
import com.office.officeserver.modules.v1.api.user.service.Imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getList();
    }


    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);

    }
}
