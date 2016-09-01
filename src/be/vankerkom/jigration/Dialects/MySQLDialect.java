package be.vankerkom.jigration.Dialects;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class MySQLDialect extends Dialect {

    public MySQLDialect() {
        supportsCreateTableIf = true;
        supportsDropTableIf = true;
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
