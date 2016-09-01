package be.vankerkom.jigration.schema;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class Sketch {

    private String columnName;
    private String columnType;

    // TODO Store the properties in it's own collection.

    public Sketch(String columnName, String columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    // Represents a column entry for the database.

    public Sketch unsigned() {

        // Makes the value unsigned.

        return this;

    }

    public Sketch value(Object defaultValue) {

        // Sets the default value

        return this;

    }

    public Sketch unique() {

        // Makes the column unique.

        return this;

    }

    public Sketch index() {

        // Makes the column an index.

        return this;

    }

    public Sketch length(int length) {

        // The size of the specified column.

        return this;

    }

    public Sketch comment(String comment) {

        // Adds a comment to the database table.

        return this;

    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnType() {
        return columnType;
    }

}
