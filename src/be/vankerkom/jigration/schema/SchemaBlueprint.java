package be.vankerkom.jigration.schema;

import be.vankerkom.jigration.Builders.Builder;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class SchemaBlueprint extends Blueprint {

    public SchemaBlueprint(String tableName, Builder builder) {
        super(tableName, builder);
    }

    public void create() {

        // Creates a new table.
        String createCommand = builder.getDialect().createTable(tableName, false);
        System.out.println("SQL >> " + createCommand);

    }

    public void alter() {

        // Alters an existing table.
        String alterCommand = builder.getDialect().alterTable(tableName);
        System.out.println("SQL >> " + alterCommand);

    }

    public void drop(boolean ifExists) {

        // Drops an existing table.
        String dropCommand = builder.getDialect().dropTable(tableName, ifExists);
        System.out.println("SQL >> " + dropCommand);

    }

}
