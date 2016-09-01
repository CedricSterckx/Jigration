package be.vankerkom.jigration.builders;

import be.vankerkom.jigration.dialects.Dialect;
import be.vankerkom.jigration.dialects.SqlServerDialect;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class SqlServerBuilder extends Builder {

    private static final String SQL_SERVER_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String SQL_SERVER_CONNECTION_STRING = "jdbc:sqlserver://%s;databaseName=%s;user=%s;password=%s;";
    private static final Dialect SQL_SERVER_DIALECT = new SqlServerDialect();

    public SqlServerBuilder(String host, String databaseName, String username, String password) throws Exception {
        super(SQL_SERVER_DRIVER_NAME, SQL_SERVER_DIALECT, String.format(SQL_SERVER_CONNECTION_STRING, host, databaseName, username, password), databaseName);;
    }

}
