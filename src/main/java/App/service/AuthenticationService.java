package App.service;

import App.User;
import App.controller.AuthController;
import App.utilities.Debugger;
import App.utilities.UniqueNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class AuthenticationService {
    private static Logger logger = LogManager.getLogger(AuthenticationService.class.getName());

    private Repository repository = Repository.getInstance();
    private HashMap<Long, Long> userIdToToken = new HashMap<>();
    private UniqueNumber tokenUniqueNumber = new UniqueNumber();
    private Set<Long> tokenSet = new HashSet<>();
    private TokenService tokenService = new TokenService();

    public Long createUser(String email, String name, String password) {
        Optional<List<String>> emails = repository.getEmails();

        if (emails.isPresent()) {
            if (emails.get().contains(email)) {
                logger.warn("Account with given Email already exists");
                return null;
            }
        }

        UniqueNumber userId = new UniqueNumber();
        long userIdNum = userId.getID();
        User newUser = new User(userIdNum, email, name, password);
        repository.writeUser(newUser);
        logger.info("User registered successfully: " + userIdNum);
        return userIdNum;
    }

    public Long logIn(String email, String password) {

        Optional<User> user = repository.getUserByEmail(email);

        if (!user.isPresent()) {
            logger.warn("User with email: " + email + " doesn't exists.");
        }
        if (!user.get().getPassword().equals(password)) {
            logger.warn("Error! Incorrect password!");
        }

        Long token;
        do {
            token = tokenUniqueNumber.getID();
        } while (tokenSet.contains(token));
        tokenService.setSession(token, user.get().getId());
        logger.info("return Token :" + token);
        return token;
    }
}