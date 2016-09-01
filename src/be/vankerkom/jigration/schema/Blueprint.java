package be.vankerkom.jigration.schema;

import be.vankerkom.jigration.builders.Builder;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class Blueprint {

    protected String tableName;
    protected Builder builder;
    protected StringBuilder sql = new StringBuilder();

    private HashMap<String, Sketch> addedColumns = new HashMap<String, Sketch>();

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
        return addColumn("string", columnName).length(length);
    }

    public Sketch string(String columnName)  {
        return string(columnName, 255);
    }

    public Sketch text(String columnName) {
        return addColumn("text", columnName);
    }

    private Sketch addColumn(String columnType, String columnName) {

        Sketch result = null;

        if (!addedColumns.containsKey(columnName)) {

            result = new Sketch(columnName, columnType);
            addedColumns.put(columnName, result);

        }else{
            System.err.println("Duplicate column found '" + columnName + "'");
        }

        return result;

    }

    public void build() {

        // Builds the blueprint against the current active connection.
        System.out.println("Building against the database... (NOT)");
        String sqlCommand = toSql();
        System.out.println("SQL Command >> " + sqlCommand);

        // Execute the building on the connection.
        //builder.query(sqlCommand);

    }

    public String toSql() {
        return sql.toString();
    }

    public String getTableName() {
        return tableName;
    }

    public ArrayList<Sketch> getAddedColumns() {
        return new ArrayList<>(addedColumns.values());
    }
}
