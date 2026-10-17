package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import in.sp.main.entity.User;
import in.sp.main.service.UserService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        System.out.println("Received: " + user.getName());
        return service.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.deleteUser(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return service.updateUser(user);
    }

    @PostMapping("/test")
    public String test(@RequestBody String data) {
        System.out.println("RAW DATA: " + data);
        return "OK";
    }
}