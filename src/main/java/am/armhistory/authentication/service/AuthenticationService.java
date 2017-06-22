package am.armhistory.authentication.service;

/**
 * Created by Gevorg Minasyan on 6/22/2017.
 */
public interface AuthenticationService {

    boolean checkEmailAvailability(String email);
    boolean checkLoginAvailability(String login);

}
