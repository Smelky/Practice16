package app.dao;

import app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    Optional findUserById(Integer id);

    List<User> findAll();
}
