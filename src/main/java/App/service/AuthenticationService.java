package App.service;

import App.Repository;
import App.User;
import App.utilities.UniqueNumber;

import java.util.HashMap;

public class AuthenticationService {
    static HashMap<User, Long> userIdTokenMap = new HashMap<User, Long>;

    // return optional token
    public void loginUser(long id, String password) {
        User user =  Repository.getUserById(id);
        if (user == null) {
            throw new RuntimeException("No user with given id");
        }
        UniqueNumber tokenUniqueNumber = new UniqueNumber();
        Long token;
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("wrong password for given");
        }
        token = tokenUniqueNumber.getID();
        if (token == null) {
            throw new RuntimeException("error while token was generated");
        }
        userLoginTokenMap(user, token);
    }

    private void userLoginTokenMap(User user, long token) {
        userIdTokenMap.put(user.getId(), token);
    }

    private static void userLogout(User user) {
        userIdTokenMap.remove(user.getId());
    }

    public static void updateName(User user, String name) {
        updateUser(user, name, user.getEmail(), user.getPassword());
    }

    public static void updateEmail(User user, String email) {
        updateUser(user, user.getName(), email, user.getPassword());
    }

    public static void userUpdatePassword(User user, String password) {
        updateUser(user, user.getName(), user.getEmail(), password);
    }

    public static void updateUser(User user, String name, String email, String password) {
        // need to check the token for this user
        if (userIdTokenMap.containsKey(user.getId())) {
            User user = Repository.getUserById(user.getId());
            user.setEmail(email);
            user.setName(name);
            user.setPassword(password);
            Repository.updateUserRepo(user);
        } else {
            throw new RuntimeException("This user is not logged in");
        }
    }

    public static void deleteUser(User user, long token) {
        if (userIdTokenMap.containsKey(user.getId())) {
            userLogout(user);
            Repository.deleteUserRepo(user);
        } else {
            throw new RuntimeException("This user is not logged in");
        }
    }
}
