package crwnow.MyWebApp2Boot.service;

import crwnow.MyWebApp2Boot.model.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    void add(User user);
    List<User> index();
    User show(int id);
    void delete(int id);
    void update(int id, @Valid User user);
}
