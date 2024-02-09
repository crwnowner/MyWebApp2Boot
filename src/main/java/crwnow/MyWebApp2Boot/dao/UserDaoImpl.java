package crwnow.MyWebApp2Boot.dao;


import crwnow.MyWebApp2Boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    public void add(User user) {
        entityManager.persist(user);
    }

    public List<User> index() {
        return entityManager.createQuery(
                "SELECT u FROM User u", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    public void delete(int id) {
        User userToDelete = entityManager.find(User.class, id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        if (userToBeUpdated != null) {
            userToBeUpdated.setName(updatedUser.getName());
            userToBeUpdated.setSurname(updatedUser.getSurname());
            userToBeUpdated.setAge(updatedUser.getAge());
        }
    }
}
