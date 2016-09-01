package be.vankerkom.jigration.Dialects;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class SQLiteDialect extends Dialect{

    @Override
    public String questionTableExists() {
        return "SELECT COUNT(*) FROM sqlite_master where type = 'table' and name = ?";
    }

    @Override
    public String questionColumnExists() {
        return null;
    }

}
