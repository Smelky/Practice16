package app.dao;

import app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(Integer id);

    Optional findById(Integer id);

    List<User> findAll();
}
