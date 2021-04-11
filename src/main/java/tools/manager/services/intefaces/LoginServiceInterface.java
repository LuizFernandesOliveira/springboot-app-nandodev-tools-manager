package tools.manager.services.intefaces;

import tools.manager.models.User;

import java.util.Optional;

public interface LoginServiceInterface {

    Optional<User> findByEmail(String email);

}
