package be.vankerkom.jigration.dialects;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class MySQLDialect extends Dialect {

    public MySQLDialect() {
        supportsCreateTableIf = true;
        supportsDropTableIf = true;

        typesResolver.put("string", "varchar(%d)");
        typesResolver.put("integer", "integer");
        typesResolver.put("text", "text");
    }

    @Override
    public String questionTableExists() {
        return "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = ? AND table_name = ?";
    }

    @Override
    public String questionColumnExists() {
        return "SELECT column_name FROM information_schema.columns WHERE table_schema = ? AND table_name = ?";
    }

}
