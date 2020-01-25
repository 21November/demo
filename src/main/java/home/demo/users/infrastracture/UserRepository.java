package home.demo.users.infrastracture;

import home.demo.halpers.IRepository;
import home.demo.users.domain.User;

import java.sql.*;
import java.util.*;

public class UserRepository implements IRepository<User> {

    private final Connection connection;

    public UserRepository() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:sample.db");
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(
                    String.format
                            (
                                    "INSERT INTO users" +
                                            "(" +
                                            "id, " +
                                            "email, " +
                                            "password)" +
                                            "VALUES('%s', '%s', '%s')",
                                    user.id.getUuid(),
                                    user.email,
                                    user.password
                            )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String name) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(
                    String.format(
                            "DELETE FROM users " +
                                    "WHERE lastName = '" + name + "'"
                    )

            );
            System.out.println("Удаляем: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List getAll() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet cursor = statement.executeQuery(
                    "SELECT * FROM users"
            );

            ResultSetMetaData md = cursor.getMetaData();
            int columns = md.getColumnCount();

            while (cursor.next()){
                Map<String, String> row = new HashMap<String, String >(columns);
                for(int i = 1; i <= columns; ++i){
                    row.put(md.getColumnName(i), cursor.getString(i));
                }

                users.add(User.fromRowTable(row));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional getById(long id) {
        return Optional.empty();
    }
}
