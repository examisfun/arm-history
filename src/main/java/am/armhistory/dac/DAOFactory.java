package am.armhistory.dac;

import am.armhistory.dac.queries.SQLQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DAOFactory {

	private final DriverManagerDataSource driverManagerDataSource;
	private final SQLQueries sqlQueries;

	@Autowired
	public DAOFactory(DriverManagerDataSource driverManagerDataSource, SQLQueries sqlQueries) {
		this.driverManagerDataSource = driverManagerDataSource;
		this.sqlQueries = sqlQueries;

	}


	/**
	 * Returns query with the specified name.
	 *
	 * @param queryName Name of the query
	 * @return query
	 */
	public final String getQuery(final String queryName) {
		return sqlQueries.getQuery(queryName);
	}

	/**
	 * Gets template for implementing data reading.
	 *
	 * @return Template for implementing data reading.
	 */
	public final NamedParameterJdbcTemplate getReadJdbcTemplate() {
		return new NamedParameterJdbcTemplate(driverManagerDataSource);
	}

	/**
	 * Returns JDBC template for data writing
	 *
	 * @return jdbc template for writing/master datasource
	 */
	public final NamedParameterJdbcTemplate getWriteJdbcTemplate() {
		return new NamedParameterJdbcTemplate(driverManagerDataSource);
	}
}
