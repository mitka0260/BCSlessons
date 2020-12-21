package ee.bcs.java.BCSSpring.conf;

import ee.bcs.java.BCSSpring.json.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public void registerUser(@RequestParam("username") String username,
                             @RequestParam("password") String password) {
        String encodedPassword = passwordEncoder.encode(password);
        userRepository.registerUser(username, encodedPassword);
    }

    @PostMapping("/registration")
    public void registerUserSafe(@RequestBody LoginRequest request) {
        userService.registerUser(request.username, request.password);
    }

}
