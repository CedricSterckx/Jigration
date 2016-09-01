package be.vankerkom.jigration.Dialects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public abstract class Dialect {

    private static final String SQL_CREATE_TABLE = "CREATE TABLE";
    private static final String SQL_CREATE_TABLE_IF = "CREATE TABLE IF NOT EXISTS";
    private static final String SQL_CREATE_TABLE_FORMAT = "%s %s (%s\n);";

    private static final String SQL_DROP_TABLE = "DROP TABLE";
    private static final String SQL_DROP_TABLE_IF = "DROP TABLE IF EXISTS";
    private static final String SQL_DROP_TABLE_FORMAT = "%s %s;";

    protected boolean supportsCreateTableIf = true;
    protected boolean supportsDropTableIf = false;

    public abstract String questionTableExists();
    public abstract String questionColumnExists();

    public String createTable(String tableName, boolean ifNotExists) {

        if (!supportsCreateTableIf && ifNotExists) {
            throw new NotImplementedException();
        }

        return String.format(
                SQL_CREATE_TABLE_FORMAT,
                (ifNotExists) ? SQL_CREATE_TABLE_IF : SQL_CREATE_TABLE,
                tableName,
                "WIP"
        );

    }

    public String alterTable(String tableName) {
        return "";
    }

    public String dropTable(String tableName, boolean ifExists) {

        if (!supportsDropTableIf && ifExists) {
            throw new NotImplementedException();
        }

        return String.format(
                SQL_DROP_TABLE_FORMAT,
                (ifExists) ? SQL_DROP_TABLE_IF : SQL_DROP_TABLE,
                tableName
        );

    }

}
