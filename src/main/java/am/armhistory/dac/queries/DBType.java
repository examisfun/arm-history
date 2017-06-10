package am.armhistory.dac.queries;

/**
 * Enumeration for database types
 */
public enum DBType {
	/**
	 * Type for mssql
	 */
	MSSQL("mssql"),
	/**
	 * Type for oracle
	 */
	ORACLE("oracle"),
	/**
	 * Type for postgre
	 */
	POSTGRE("postgre"),
	/**
	 * Type for mysql
	 */
	MYSQL("mysql");

	private String title = null;

	DBType(String title) {
		this.title = title;
	}

	/**
	 * Gets title of the database type
	 *
	 * @return title of the database type
	 */
	public String getTitle() {
		return title;
	}
}
