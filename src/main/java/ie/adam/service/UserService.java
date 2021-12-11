package ie.adam.service;

import ie.adam.entities.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findById(String email);
}
