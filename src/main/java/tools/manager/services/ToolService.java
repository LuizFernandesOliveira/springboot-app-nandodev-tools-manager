package tools.manager.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tools.manager.models.Tag;
import tools.manager.models.Tool;
import tools.manager.models.User;
import tools.manager.repositories.TagRepository;
import tools.manager.repositories.ToolRepository;
import tools.manager.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ToolService {
    private final ToolRepository toolRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    public Tool create(Tool tool) {
        List<Tag> tags = tagRepository.saveAll(tool.getTags());
        tool.setTags(tags);

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        User loggedUser = userRepository.findByEmail(username).orElse(null);
        if (loggedUser != null) {
            tool.setUser(loggedUser);
        }
        Tool toolSaved = toolRepository.save(tool);
        return toolSaved;
    }

    public List<Tool> findAll() {
        return toolRepository.findAll();
    }

    public List<Tool> findAllByUser() {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        User loggedUser = userRepository.findByEmail(username).orElse(null);
        return toolRepository.findAllByUser(loggedUser);
    }
}
