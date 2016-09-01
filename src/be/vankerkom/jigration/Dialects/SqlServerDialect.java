package be.vankerkom.jigration.Dialects;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class SqlServerDialect extends Dialect {

    @Override
    public String questionTableExists() {
        return "SELECT COUNT(*) FROM sysobjects WHERE type = 'U' AND name = ?";
    }

    @Override
    public String questionColumnExists() {
        return null;
    }

}
