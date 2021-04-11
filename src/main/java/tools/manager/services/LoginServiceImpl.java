package tools.manager.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.manager.models.User;
import tools.manager.repositories.UserRepository;
import tools.manager.services.intefaces.LoginServiceInterface;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginServiceInterface {

    final private UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
