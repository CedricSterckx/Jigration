package be.vankerkom.jigration.dialects;

import be.vankerkom.jigration.schema.Blueprint;
import be.vankerkom.jigration.schema.Sketch;

import java.util.LinkedHashMap;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public abstract class Dialect {

    public static final String NOT_SUPPORTED_EXCEPTION = "This feature not supported by the database driver.";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE";
    private static final String SQL_CREATE_TABLE_IF = "CREATE TABLE IF NOT EXISTS";
    private static final String SQL_CREATE_TABLE_FORMAT = "%s %s (%s\n);";

    public static final String SQL_ALTER_TABLE = "ALTER TABLE";
    public static final String SQL_ALTER_TABLE_FORMAT = "%s %s %s;";

    private static final String SQL_DROP_TABLE = "DROP TABLE";
    private static final String SQL_DROP_TABLE_IF = "DROP TABLE IF EXISTS";
    private static final String SQL_DROP_TABLE_FORMAT = "%s %s;";

    protected boolean supportsCreateTableIf = true;
    protected boolean supportsDropTableIf = false;

    protected LinkedHashMap<String, String> typesResolver = new LinkedHashMap<>();

    public abstract String questionTableExists();
    public abstract String questionColumnExists();

    public String createTable(Blueprint blueprint, boolean ifNotExists) throws Exception {

        if (!supportsCreateTableIf && ifNotExists) {
            throw new Exception(NOT_SUPPORTED_EXCEPTION);
        }

        return String.format(
                SQL_CREATE_TABLE_FORMAT,
                (ifNotExists) ? SQL_CREATE_TABLE_IF : SQL_CREATE_TABLE,
                blueprint.getTableName(),
                getColumns(blueprint)
        );

    }

    public String alterTable(Blueprint blueprint) {

        return String.format(
                SQL_ALTER_TABLE_FORMAT,
                SQL_ALTER_TABLE,
                blueprint.getTableName(),
                getColumns(blueprint)
        );

    }

    public String dropTable(Blueprint blueprint, boolean ifExists) throws Exception {

        if (!supportsDropTableIf && ifExists) {
            throw new Exception(NOT_SUPPORTED_EXCEPTION);
        }

        return String.format(
                SQL_DROP_TABLE_FORMAT,
                (ifExists) ? SQL_DROP_TABLE_IF : SQL_DROP_TABLE,
                blueprint.getTableName()
        );

    }

    protected String getColumns(Blueprint blueprint) {

        StringBuilder builder = new StringBuilder();

        for(Sketch column : blueprint.getAddedColumns()) {

            // Build every column based on the given properties.
            builder.append(buildColumn(blueprint, column));

        }

        return builder.toString();

    }

    protected String buildColumn(Blueprint blueprint, Sketch column) {

        // TODO Translate the type.
        // TODO Apply set properties

        System.out.println(blueprint.getTableName() + " -> " + column.getColumnName() + ":" + resolveType(column));

        return "";

    }

    private String resolveType(Sketch column) {

        if (typesResolver.containsKey(column.getColumnType())) {
            return typesResolver.get(column.getColumnType());
        }

        return "";

    }

}
