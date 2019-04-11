package mate.hw13.sql;

import java.sql.SQLException;

public class ConsoleApplication {

    public static void main(String[] args) throws SQLException {
        CrudOperations operations = new CrudOperations();
        operations.delete();
        operations.create();
        operations.read();
        operations.update();
    }
}