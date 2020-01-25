package home.demo.users.application.services;

import home.demo.users.application.services.exception.UserPasswordInvalidException;
import home.demo.users.domain.User;
import home.demo.users.infrastracture.UserRepository;

import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService() throws SQLException {
        this.userRepository = new UserRepository();
    }

    public List<User> getUsers() {
        return this.userRepository.getAll();
    }

    public void ensureUserDataCorrect(User user, String password)
            throws Exception{

        String encodedPassword =
                Base64.getEncoder().encodeToString(password.getBytes());
        if (!user.password.equals(encodedPassword)){
            throw new UserPasswordInvalidException();
        }
    }

}
