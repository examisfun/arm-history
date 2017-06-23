package am.armhistory.authentication.dao;

import am.armhistory.authentication.model.UserDto;

/**
 * Created by Gevorg Minasyan on 6/22/2017.
 */
public interface AuthenticationDao {

    boolean checkEmailAvailability(String email);
    boolean checkLoginAvailability(String login);
	void saveUser(UserDto userDto);
}
