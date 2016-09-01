package be.vankerkom.jigration.builders;

import be.vankerkom.jigration.dialects.Dialect;
import be.vankerkom.jigration.dialects.MySQLDialect;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class MySQLBuilder extends Builder {

    private static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String MYSQL_CONNECTION_STRING = "jdbc:mysql://%s/%s?user=%s&password=%s";
    private static final Dialect MYSQL_DIALECT = new MySQLDialect();

    public MySQLBuilder(String host, String schema, String username, String password) throws Exception {
        super(MYSQL_DRIVER_NAME, MYSQL_DIALECT, String.format(MYSQL_CONNECTION_STRING, host, schema, username, password), schema);
    }

    @Override
    public boolean hasTable(String tableName) {

        String hasTableQuestion = getDialect().questionTableExists();
        String currentSchema = getSchemaName();
        String tablePrefix = getTablePrefix();

        return count(hasTableQuestion, currentSchema, tablePrefix + tableName) > 0;

    }
}
