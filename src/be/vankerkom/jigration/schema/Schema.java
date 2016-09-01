package be.vankerkom.jigration.schema;

import be.vankerkom.jigration.builders.Builder;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class Schema {

    private static Builder builder;

    public static boolean hasTable(String tableName) {
        return builder.hasTable(tableName);
    }

    public static boolean hasColumn(String tableName, String columnName) {

        String hasColumnQuestion = builder.getDialect().questionColumnExists();
        String currentSchema = builder.getSchemaName();
        String tablePrefix = builder.getTablePrefix();

        // TODO Fetch the names into a string arraylist.
        // TODO Check if the name is in the list.

        System.out.println("hasColumn is not implemented.");

        return false; //builder.count(hasColumnQuestion, currentSchema, tablePrefix + tableName) > 0;

    }

    public static void create(String tableName, SchemaBuilder schemaBuilder) {

        SchemaBlueprint blueprint = new SchemaBlueprint(tableName, builder);

        schemaBuilder.forge(blueprint);

        blueprint.create();

        blueprint.build();

    }

    public static void edit(String tableName, SchemaBuilder schemaBuilder) {

        SchemaBlueprint blueprint = new SchemaBlueprint(tableName, builder);

        schemaBuilder.forge(blueprint);

        blueprint.alter();

        blueprint.build();

    }

    public static void drop(String tableName) {

        SchemaBlueprint blueprint = new SchemaBlueprint(tableName, builder);

        blueprint.drop(false);

        blueprint.build();

    }

    public static void dropIfExists(String tableName) {

        SchemaBlueprint blueprint = new SchemaBlueprint(tableName, builder);

        blueprint.drop(true);

        blueprint.build();

    }

    public static void rename(String tableName, String newTableName) {

        // TODO Implement table renaming, it's altering the table.

    }

    public static void setBuilder(Builder builder) {
        Schema.builder = builder;
    }
}
