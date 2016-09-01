package be.vankerkom.jigration.schema;

import be.vankerkom.jigration.builders.Builder;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class SchemaBlueprint extends Blueprint {

    public SchemaBlueprint(String tableName, Builder builder) {
        super(tableName, builder);
    }

    public void create() {

        // Creates a new table.
        String createCommand = "";
        try {
            createCommand = builder.getDialect().createTable(this, false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        sql.append(createCommand);

    }

    public void alter() {

        // Alters an existing table.
        String alterCommand = builder.getDialect().alterTable(this);
        sql.append(alterCommand);

    }

    public void drop(boolean ifExists) {

        // Drops an existing table.
        String dropCommand = "";
        try {
            dropCommand = builder.getDialect().dropTable(this, ifExists);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        sql.append(dropCommand);

    }

}
