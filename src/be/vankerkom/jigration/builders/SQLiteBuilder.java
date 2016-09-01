package be.vankerkom.jigration.builders;

import be.vankerkom.jigration.dialects.Dialect;
import be.vankerkom.jigration.dialects.SQLiteDialect;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class SQLiteBuilder extends Builder {

    private static final String SQLITE_DRIVER_NAME = "org.sqlite.JDBC";
    private static final String SQLITE_CONNECTION_STRING = "jdbc:sqlite:%s";
    private static final Dialect SQLITE_DIALECT = new SQLiteDialect();

    public SQLiteBuilder(String schema) throws Exception {
        super(SQLITE_DRIVER_NAME, SQLITE_DIALECT, String.format(SQLITE_CONNECTION_STRING, schema), schema);
    }

}
