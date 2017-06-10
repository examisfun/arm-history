package am.armhistory.dac.queries;

/**
 * Base interface for accessing queries by query id
 */
public interface Queries {

	/**
	 * Gets query by provided query id
	 *
	 * @param id
	 *            Provided query id
	 * @return Sql Query
	 */
	String getQuery(String id);
}
