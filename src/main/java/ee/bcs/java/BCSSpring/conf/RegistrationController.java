package ee.bcs.java.BCSSpring.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public void registerUser(@RequestParam("username") String username,
                             @RequestParam("password") String password) {
        userRepository.registerUser(username, password);
    }

}
