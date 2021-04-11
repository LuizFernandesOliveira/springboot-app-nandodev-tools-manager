package tools.manager.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tools.manager.models.User;
import tools.manager.repositories.UserRepository;
import tools.manager.services.intefaces.UserServiceInterface;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    final private UserRepository userRepository;

    @Override
    public User createUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
}
