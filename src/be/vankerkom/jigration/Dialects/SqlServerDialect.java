package be.vankerkom.jigration.dialects;

/**
 * Created by Daan Vankerkom on 1/09/2016.
 */
public class SqlServerDialect extends Dialect {

    public SqlServerDialect() {

    }

    @Override
    public String questionTableExists() {
        return "SELECT COUNT(*) FROM sysobjects WHERE type = 'U' AND name = ?";
    }

    @Override
    public String questionColumnExists() {
        return null;
    }

}
