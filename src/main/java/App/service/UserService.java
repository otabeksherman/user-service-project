package App.service;

import App.User;
import App.utilities.UniqueNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static App.service.TokenService.getIDFromToken;

public class UserService {

    private Repository repository = Repository.getInstance();
    private HashMap<Long, Long> userIdTokenMap = new HashMap<>();
    private Set<Long> tokenSet = new HashSet<>();
    private UniqueNumber tokenUniqueNumber = new UniqueNumber();
    private Set<Long> loggedIdUsers = new HashSet<>();
    private TokenService tokenService = new TokenService();

    public void updateName(long token, String newName) {
        Long id=getIDFromToken(token);
        if (id !=null) {
            Optional<User> user = repository.getUserById(getIDFromToken(id));
            if (user.isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        newName, user.get().getEmail(), user.get().getPassword());
                repository.updateUser(updatedUser);
            } else {
                System.out.println("Can't update name");
            }
        } else {
            System.out.println("The token is invalid");
        }
    }

    public void updateEmail( long token, String newEmail) {
        Long id=getIDFromToken(token);
        if (id !=null) {
            Optional<User> user = repository.getUserById(getIDFromToken(id));
            if (user.isPresent() && !repository.getUserByEmail(newEmail).isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        user.get().getName(), newEmail, user.get().getPassword());
                repository.updateUser(updatedUser);
            } else {
                System.out.println("Can't update email");
            }
        } else {
            System.out.println("The token is invalid");
        }
    }

    public void userUpdatePassword( long token, String newPassword) {
        Long id=getIDFromToken(token);
        if (id !=null) {
            Optional<User> user = repository.getUserById(getIDFromToken(id));
            if (user.isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        user.get().getName(), user.get().getEmail(), newPassword);
                repository.updateUser(updatedUser);
            } else {
                System.out.println("Can't update password");
            }
        } else {
            System.out.println("The token is invalid");
        }
    }

    public void deleteUser( long token) {
        Long id=getIDFromToken(token);
        if (id !=null) {
            Optional<User> user = repository.getUserById(getIDFromToken(id));
            if (user.isPresent()) {
                repository.deleteUser(user.get());

            } else {
                System.out.println("Can't delete user.");
            }
        } else {
            System.out.println("The token is invalid");
        }
    }
}
