package dio.santander.santander_week.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.santander.santander_week.model.User;
import dio.santander.santander_week.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @Autowired
    // UserService userService;

    @GetMapping
    public Iterable<User> buscarTodos() {
        return userService.buscarTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findbyId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findbyId(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {

        var userCreated = userService.create(userToCreate);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);

        // userService.create(userToCreate);
        // return ResponseEntity.ok(userService.create(userToCreate));
    }
}
