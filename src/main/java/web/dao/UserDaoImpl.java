package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoImpl implements UserDao{
    List<User> allUsers = new ArrayList<>();
    private static int USER_COUNT;

    {
        allUsers.add(new User(++USER_COUNT, "Tom", "tom@mail.com"));
        allUsers.add(new User(++USER_COUNT, "Bob", "bob@mail.com"));
        allUsers.add(new User(++USER_COUNT, "Mike", "mike@mail.com"));
    }

    @Override
    public List<User> getAllUsers() {
        return allUsers;
    }

    @Override
    public User getUser(int id) {
        return allUsers.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void addUser(User user) {
        user.setId(++USER_COUNT);
        allUsers.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User user = getUser(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {
        allUsers.removeIf(user -> user.getId() == id);
    }
}
