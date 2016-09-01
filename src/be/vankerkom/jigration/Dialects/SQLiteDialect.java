package be.vankerkom.jigration.dialects;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class SQLiteDialect extends Dialect{

    public SQLiteDialect() {
        supportsCreateTableIf = true;
    }

    @Override
    public String questionTableExists() {
        return "SELECT COUNT(*) FROM sqlite_master WHERE type = 'table' AND name = ?";
    }

    @Override
    public String questionColumnExists() {
        return "";
    }

}
