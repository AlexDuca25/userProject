package fastTrackIt.userProject.service;

import fastTrackIt.userProject.exceptions.UserNotFoundException;
import fastTrackIt.userProject.model.User;
import fastTrackIt.userProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private UserRepository repository;
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    public User addUser(User newUser) {
        return repository.save(newUser);
    }

    public User updateUser(User updateUser, Integer id) {
        return repository.findById(id)
                .map(User->{
                    User.setUser_name(updateUser.getUser_name());
                    User.setUser_username(updateUser.getUser_username());
                    User.setUser_email(updateUser.getUser_email());
                    User.setUser_age(updateUser.getUser_age());
                    User.setUser_password(updateUser.getUser_password());
                    return repository.save(updateUser);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    public String deleteUser(Integer id) {
        repository.deleteById(id);
        return "The user was deleted";
    }
}
