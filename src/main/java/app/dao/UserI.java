package app.dao;

import app.model.User;

import java.util.List;

public interface UserI {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findUserById(Integer id);

    List<User> getAllUsers();
}
