package tools.manager.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.manager.models.Tool;
import tools.manager.repositories.TagRepository;
import tools.manager.services.ToolService;

import java.util.List;

@RequestMapping("/tools")
@RestController
@AllArgsConstructor
public class ToolController {
    private final ToolService toolService;
    private final TagRepository tagRepository;

    @PostMapping
    public ResponseEntity<Tool> create(@RequestBody Tool tool) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toolService.create(tool));
    }

    @GetMapping
    public ResponseEntity<List<Tool>> findAllByUser() {
        return ResponseEntity.status(HttpStatus.OK).body(toolService.findAllByUser());
    }
}
