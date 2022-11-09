package App.service;

import App.User;
import App.utilities.Debugger;
import App.utilities.UniqueNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static App.service.TokenService.getIDFromToken;

public class UserService {
    private static Logger logger = LogManager.getLogger(UserService.class.getName());


    private Repository repository = Repository.getInstance();
    private HashMap<Long, Long> userIdTokenMap = new HashMap<>();
    private Set<Long> tokenSet = new HashSet<>();
    private UniqueNumber tokenUniqueNumber = new UniqueNumber();
    private Set<Long> loggedIdUsers = new HashSet<>();
    private TokenService tokenService = new TokenService();

    public void updateName(long token, String newName) {
        Long id = getIDFromToken(token);
        if (id != null) {
            Optional<User> user = repository.getUserById(id);
            if (user.isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        user.get().getEmail(), newName, user.get().getPassword());
                repository.updateUser(updatedUser);
                logger.info("User Name updated successfully");
            } else {
                logger.error("Can't update name");
            }
        } else {
            logger.error("The token is invalid");
        }
    }

    public void updateEmail(long token, String newEmail) {
        Long id = getIDFromToken(token);
        if (id != null) {
            Optional<User> user = repository.getUserById(id);
            if (user.isPresent() && !repository.getUserByEmail(newEmail).isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        newEmail, user.get().getName(), user.get().getPassword());
                repository.updateUser(updatedUser);
                logger.info("User Email updated successfully");
            } else {
                logger.fatal("Can't update email");
            }
        } else {
            logger.fatal("The token is invalid");
        }
    }

    public void userUpdatePassword(long token, String newPassword) {
        Long id = getIDFromToken(token);
        if (id != null) {
            Optional<User> user = repository.getUserById(id);
            if (user.isPresent()) {
                User updatedUser = new User(user.get().getId(),
                        user.get().getEmail(), user.get().getName(), newPassword);
                repository.updateUser(updatedUser);
                logger.info("User Password updated successfully");
            } else {
                logger.fatal("Can't update password");
            }
        } else {
            logger.fatal("The token is invalid");
        }
    }

    public void deleteUser(long token) {
        Long id = getIDFromToken(token);
        if (id != null) {
            Optional<User> user = repository.getUserById(id);
            if (user.isPresent()) {
                if (repository.deleteUser(user.get())) {
                    logger.info("User Account deleted successfully");
                }
            } else {
                logger.warn("Can't delete user.");
            }
        } else {
            logger.error("The token is invalid");
        }
    }
}
