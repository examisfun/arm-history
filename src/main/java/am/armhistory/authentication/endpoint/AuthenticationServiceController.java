package am.armhistory.authentication.endpoint;

import am.armhistory.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gevorg Minasyan on 6/22/2017.
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationServiceController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationServiceController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
    public boolean checkEmailAvailability(@RequestParam  String email){
        return authenticationService.checkEmailAvailability(email);
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    public boolean checkLoginAvailability(@RequestParam String login){
        return authenticationService.checkLoginAvailability(login);
    }

}
