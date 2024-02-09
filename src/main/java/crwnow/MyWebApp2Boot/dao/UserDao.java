package crwnow.MyWebApp2Boot.dao;


import crwnow.MyWebApp2Boot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> index();
    User show(int id);
    void delete(int id);
    void update(int id, User user);
}
