package App.service;
import App.Repository;
import App.User;
import App.utilities.UniqueNumber;

public class UserService {
    public static User createUser(String name, String email, String password) {
        if (Repository.getUserById.getEmail() != null)
            throw new RuntimeException("User already registered with this email");
        UniqueNumber userId = new UniqueNumber();
        long userIdNum = userId.getID();
        if (Repository.getUserById(userIdNum) != null)
            throw new RuntimeException("User already registered with this id number");
        User newUser = new User(userIdNum, name, email, password);
        Repository.writeUser(newUser);
        return newUser;
    }
}