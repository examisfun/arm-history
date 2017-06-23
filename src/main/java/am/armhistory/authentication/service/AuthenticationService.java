package am.armhistory.authentication.service;

import am.armhistory.authentication.model.UserDto;
import am.armhistory.authentication.model.UserValidationResultDto;

/**
 * Created by Gevorg Minasyan on 6/22/2017.
 */
public interface AuthenticationService {

    boolean checkEmailAvailability(String email);
    boolean checkLoginAvailability(String login);
	UserValidationResultDto saveUser(UserDto userDto);
}
