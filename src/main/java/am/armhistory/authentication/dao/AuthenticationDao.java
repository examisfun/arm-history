package am.armhistory.authentication.dao;

/**
 * Created by Gevorg Minasyan on 6/22/2017.
 */
public interface AuthenticationDao {

    boolean checkEmailAvailability(String email);
    boolean checkLoginAvailability(String login);

}
