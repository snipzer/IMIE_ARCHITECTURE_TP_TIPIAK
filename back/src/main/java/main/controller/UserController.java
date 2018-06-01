package main.controller;

import main.entity.User;
import main.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Optional<User>> getUser(@RequestParam Long id) {
        Optional<User> user = this.userService.findById(id);
        HttpStatus status = HttpStatus.OK;
        if(user == null) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(user, status);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@ModelAttribute User user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.OK);
    }

    @PostMapping("/user/update")
    public ResponseEntity<User> updateUser(@ModelAttribute User user) {
        return new ResponseEntity<>(this.userService.updateEntity(user), HttpStatus.OK);
    }

    @PostMapping("/user/delete")
    public ResponseEntity deleteUser(@RequestParam Long id) {
        this.userService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
