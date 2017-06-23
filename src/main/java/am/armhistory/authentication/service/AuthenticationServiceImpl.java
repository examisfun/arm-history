package am.armhistory.authentication.service;

import am.armhistory.authentication.dao.AuthenticationDao;
import am.armhistory.authentication.model.UserDto;
import am.armhistory.authentication.model.UserValidationResultDto;
import com.google.common.base.Strings;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gevorg Minasyan on 6/22/2017.
 */
@Repository
public class AuthenticationServiceImpl implements AuthenticationService {

	private final AuthenticationDao authenticationDao;

	@Autowired
	public AuthenticationServiceImpl(AuthenticationDao authenticationDao) {
		this.authenticationDao = authenticationDao;
	}

	@Override
	public boolean checkEmailAvailability(String email) {
		return authenticationDao.checkEmailAvailability(email);
	}

	@Override
	public boolean checkLoginAvailability(String login) {
		return authenticationDao.checkLoginAvailability(login);
	}

	@Override
	public UserValidationResultDto saveUser(UserDto userDto) {
		UserValidationResultDto userValidationResultDto = validate(userDto);
		if (userValidationResultDto.getValidationErrors().isEmpty()) {
			this.authenticationDao.saveUser(userDto);
		}
		return userValidationResultDto;
	}

	private UserValidationResultDto validate(UserDto userDto) {
		Map<String, String> validationErrors = new HashMap<>();

		if (Strings.isNullOrEmpty(userDto.getFirstName())) {
			validationErrors.put("firstName", "required");
		}

		if (Strings.isNullOrEmpty(userDto.getLastName())) {
			validationErrors.put("lastName", "required");
		}

		String login = userDto.getLogin();
		if (Strings.isNullOrEmpty(login)) {
			validationErrors.put("login", "required");
		}
		if (login != null) {
			if (login.length() < 6) {
				validationErrors.put("login", "minlength");
			}
			if (authenticationDao.checkLoginAvailability(login)) {
				validationErrors.put("login", "used");
			}
		}

		String email = userDto.getEmail();
		if (Strings.isNullOrEmpty(email)) {
			validationErrors.put("email", "required");
		}
		if (email != null) {
			String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if (!email.matches(emailRegex)) {
				validationErrors.put("email", "pattern");
			}
			if (authenticationDao.checkEmailAvailability(email)) {
				validationErrors.put("email", "used");
			}
		}

		String password = userDto.getPassword();
		if (Strings.isNullOrEmpty(password)) {
			validationErrors.put("password", "required");
		}
		if (password != null && password.length() < 6) {
			validationErrors.put("password", "minlength");
		}

		String repeatPassword = userDto.getRepeatPassword();
		if (Strings.isNullOrEmpty(repeatPassword)) {
			validationErrors.put("repeatPassword", "required");
		}

		if (password != null && repeatPassword != null && !password.equals(repeatPassword)) {
			validationErrors.put("repeatPassword", "notSame");
		}

		UserValidationResultDto userValidationResult = new UserValidationResultDto();
		userValidationResult.setValidationErrors(validationErrors);
		return userValidationResult;
	}
}
