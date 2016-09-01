package be.vankerkom.jigration.Builders;

import be.vankerkom.jigration.Dialects.Dialect;

import java.sql.*;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class Builder {

    // Represents the connection between the application and the database.

    private String connectionString = "";
    private String driverClass = "";
    private Dialect dialect;

    private String schemaName = "";
    private String tablePrefix = "";

    private Connection connection;

    public Builder(String driverClass, Dialect dialect, String connectionString, String schemaName) throws Exception {

        this.driverClass = driverClass;
        this.connectionString = connectionString;
        this.dialect = dialect;
        this.schemaName = schemaName;

        prepare();

    }

    private void prepare() throws Exception {

        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Missing dependency: " + driverClass);
            e.printStackTrace();
            throw new Exception("Missing dependency: " + driverClass);
        }

        try {
            this.connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Could not connect to the database.");
        }

    }

    public boolean build() {

        // Build the migrations on in the database.

        return true;
    }

    public int count(String query, Object... parameters) {

        int result = 0;

        try {

            PreparedStatement statement = connection.prepareStatement(query);

            int currentParameter = 1;
            for(Object parameter : parameters) {
                statement.setObject(currentParameter++, parameter);
            }

            ResultSet resultSet = statement.executeQuery();
            resultSet.first();
            result = resultSet.getInt(1);
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public Dialect getDialect() {
        return dialect;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

}
