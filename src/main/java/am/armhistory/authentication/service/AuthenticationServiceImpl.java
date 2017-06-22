package am.armhistory.authentication.service;

import am.armhistory.authentication.dao.AuthenticationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Gevorg Minasyan on 6/22/2017.
 */
@Repository
public class AuthenticationServiceImpl implements AuthenticationService{

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
}
