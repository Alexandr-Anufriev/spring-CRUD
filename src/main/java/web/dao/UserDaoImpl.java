package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Query query = entityManager.createNativeQuery("select * from user", User.class);
        List<User> list = query.getResultList();
        return list;
    }

    @Override

    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override

    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override

    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override

    public void delete(int id) {
        entityManager.remove(getUser(id));
    }


//    private static int USER_COUNT;
//
//    private static final String URL = "jdbc:mysql://127.0.0.1:3306/mydbtest?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//
//    private static Connection connection;
//
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM User";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while(resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setEmail(resultSet.getString("email"));
//
//                userList.add(user);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return userList;
//    }
//
//    @Override
//    public User getUser(int id) {
//        User user = new User();
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("SELECT * FROM User WHERE id=?");
//            preparedStatement.setInt(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setEmail(resultSet.getString("email"));
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return user;
//    }
//
//    @Override
//    public void addUser(User user) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO User VALUES(?,?,?)");
//            preparedStatement.setInt(1, ++USER_COUNT);
//            preparedStatement.setString(2, user.getName());
//            preparedStatement.setString(3, user.getEmail());
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(int id, User updatedUser) {
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("UPDATE User SET name=?, email=? WHERE id=?");
//            preparedStatement.setInt(3,id);
//            preparedStatement.setString(1,updatedUser.getName());
//            preparedStatement.setString(2,updatedUser.getEmail());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(int id) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM User WHERE id=?");
//            preparedStatement.setInt(1,id);
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
}
