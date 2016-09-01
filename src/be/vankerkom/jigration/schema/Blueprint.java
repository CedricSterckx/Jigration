package be.vankerkom.jigration.schema;

import be.vankerkom.jigration.Builders.Builder;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class Blueprint {

    protected String tableName;
    protected Builder builder;

    public Blueprint(String tableName, Builder builder) {
        this.tableName = tableName;
        this.builder = builder;
    }

    public Sketch increments(String columnName) {
        return addColumn("integer", columnName);
    }

    public Sketch integer(String columnName) {
        return addColumn("integer", columnName);
    }

    public Sketch string(String columnName, int length) {
        return addColumn("string", columnName);
    }

    public Sketch string(String columnName)  {
        return string(columnName, 255);
    }

    public Sketch text(String columnName) {
        return addColumn("text", columnName);
    }

    private Sketch addColumn(String columnType, String columnName) {

        return new Sketch();

    }

    public void build() {

        // Builds the blueprint against the current active connection.


        // Execute the building on the connection.

    }

}
