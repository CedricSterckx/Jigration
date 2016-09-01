package be.vankerkom.jigration;

import be.vankerkom.jigration.builders.Builder;
import be.vankerkom.jigration.builders.SQLiteBuilder;
import be.vankerkom.jigration.schema.Blueprint;
import be.vankerkom.jigration.schema.Schema;
import be.vankerkom.jigration.schema.SchemaBuilder;

public class Main {

    public static void main(String[] args) {

        // Let's build a test migration.
        System.out.println("Jigration by Daan Vankerkom");
        System.out.println("Easy migration for SQL databases.");
        System.out.println();
        System.out.println("Migration test.");
        System.out.println();

        testMigration();

    }

    private static void testMigration() {

        System.out.println("Creating new builder...");
        Builder activeBuilder = null;
        try {
            //activeBuilder = new MySQLBuilder("127.0.0.1:3306", "jigration", "root", "");
            activeBuilder = new SQLiteBuilder("jigration.db");
        } catch (Exception e) {
            System.err.println("Failed to initialize the connection.");
            e.printStackTrace();
            return;
        }

        System.out.println("Setting active builder to: " + activeBuilder.toString());

        Schema.setBuilder(activeBuilder);

        System.out.println("Checking if the table users exists.");

        if (Schema.hasTable("users")) {
            System.out.println("Users exists.");
        }else{
            System.out.println("Users does not exist.");
        }

        System.out.println("Checking if the table users table has the column friends..");

        if (Schema.hasColumn("users", "friends")) {
            System.out.println("Users has the column friends.");
        }else{
            System.out.println("Users does not have the column friends.");
        }

        System.out.println("Creating users table...");

        Schema.create("users", new SchemaBuilder() {

            @Override
            public void forge(Blueprint table) {

                table.increments("id");
                table.string("username").unique();
                table.string("password");
                table.string("email").unique();
                table.integer("coins").unsigned();
                table.text("bio").comment("a description of the user.");

            }

        });

        System.out.println("Renaming users to user...");

        Schema.rename("users", "user");

        System.out.println("Dropping user.");

        Schema.drop("user");

        System.out.println("Dropping users if it exists.");

        Schema.dropIfExists("users");

    }


}
