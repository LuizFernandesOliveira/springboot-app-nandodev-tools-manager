package tools.manager.services.intefaces;

import tools.manager.models.User;

import java.util.List;

public interface UserServiceInterface {

    User createUser(User user);

    List<User> findAll();

}
