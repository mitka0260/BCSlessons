package ee.bcs.java.BCSSpring.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("registration")
    public void registerUser() {
        userRepository.registerUser();
    }

}
