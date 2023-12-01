package fastTrackIt.userProject.controller;

import fastTrackIt.userProject.model.User;
import fastTrackIt.userProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users_list")
@CrossOrigin("http://localhost:3000")
public class UserController {
    private UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
    @GetMapping("user/{id}")
    public User getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }
    @PostMapping("/user")
    public User addUser(@RequestBody User newUser){
        return service.addUser(newUser);
    }
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User updateUser, @PathVariable Integer id){
        return service.updateUser(updateUser,id);
    }
    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id){
        return service.deleteUser(id);
    }
}
