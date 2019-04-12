package mate.hw13.sql;

import sun.security.rsa.RSASignature;
import util.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudOperations {

    private static final String INSERT_QUERY = "insert into developers(name, age, sex, salary) values (?, ?, ?, ?)";
    private static final String SELECT_QUERY = "select name, age, sex from developers where name = ?";
    private static final String UPDATE_QUERY = "update developers set salary = 40 where name = ?";
    private static final String DELETE_QUERY = "delete from developers where name = ?";

    public static void create() throws SQLException {
        Connection connection = JdbcConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, "Anja");
            preparedStatement.setInt(2, 21);
            preparedStatement.setString(3, "female");
            preparedStatement.setInt(4, 20);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }

    public List<Developer> read() throws SQLException {
        ResultSet resultSet = null;
        Connection connection = JdbcConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            List<Developer> developers = new ArrayList<Developer>();
            resultSet = preparedStatement.executeQuery(SELECT_QUERY);
            while (resultSet.next()) {
                Developer developer = new Developer(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
                developers.add(developer);
                return developers;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
        return null;
    }

    public void update() throws SQLException {
        Connection connection = JdbcConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, "Anja");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }


    public void delete() throws SQLException {
        Connection connection = JdbcConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setString(1, "Alex");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }
}

