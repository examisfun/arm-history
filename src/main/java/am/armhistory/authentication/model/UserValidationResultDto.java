package am.armhistory.authentication.model;

import java.util.Map;

/**
 * Created by davos on 6/23/2017.
 */
public class UserValidationResultDto {
	private Map<String, String> validationErrors;

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}
}
