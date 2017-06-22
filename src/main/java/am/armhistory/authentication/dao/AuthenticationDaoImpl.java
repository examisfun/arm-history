package am.armhistory.authentication.dao;

import am.armhistory.dac.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * Created by Gevorg Minasyan on 6/22/2017.
 */
@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {

    private DAOFactory authenticationDaoFactory;

    @Autowired
    public AuthenticationDaoImpl(DAOFactory authenticationDaoFactory) {
        this.authenticationDaoFactory = authenticationDaoFactory;
    }

    @Override
    public boolean checkEmailAvailability(String email) {
        String sql = authenticationDaoFactory.getQuery("checkEmailAvailability");
        SqlParameterSource namedParameters = new MapSqlParameterSource("email", email);
        return authenticationDaoFactory.getReadJdbcTemplate().query(sql, namedParameters, rs -> {
            rs.next();
            return rs.getBoolean("isAvailable");
        });
    }

    @Override
    public boolean checkLoginAvailability(String login) {
        String sql = authenticationDaoFactory.getQuery("checkLoginAvailability");
        SqlParameterSource namedParameters = new MapSqlParameterSource("login", login);
        return authenticationDaoFactory.getReadJdbcTemplate().query(sql, namedParameters, rs -> {
            rs.next();
            return rs.getBoolean("isAvailable");
        });
    }
}
