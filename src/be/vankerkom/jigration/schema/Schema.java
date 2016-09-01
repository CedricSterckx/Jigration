package be.vankerkom.jigration.schema;

import be.vankerkom.jigration.Builders.Builder;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class Schema {

    private static Builder builder;

    public static boolean hasTable(String tableName) {

        String hasTableQuestion = builder.getDialect().questionTableExists();
        String currentSchema = builder.getSchemaName();
        String tablePrefix = builder.getTablePrefix();

        return builder.count(hasTableQuestion, currentSchema, tablePrefix + tableName) > 0;

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

    public static void drop(String tableName) {

        SchemaBlueprint blueprint = new SchemaBlueprint(tableName, builder);

        blueprint.drop(false);

    }

    public static void dropIfExists(String tableName) {

        SchemaBlueprint blueprint = new SchemaBlueprint(tableName, builder);

        blueprint.drop(true);

    }

    public static void rename(String tableName, String newTableName) {

        // TODO Implement table renaming, it's altering the table.

    }

    public static void setBuilder(Builder builder) {
        Schema.builder = builder;
    }
}
