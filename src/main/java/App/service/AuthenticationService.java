package App.service;
import App.User;
import App.utilities.UniqueNumber;

import java.util.*;

public class AuthenticationService {

    private Repository repository = Repository.getInstance();
    private HashMap<Long, Long> userIdToToken = new HashMap<>();
    private UniqueNumber tokenUniqueNumber = new UniqueNumber();
    private Set<Long> tokenSet = new HashSet<>();
    private TokenService tokenService = new TokenService();

    public User createUser(String name, String email, String password) {
        Optional<List<String>> emails = repository.getEmails();

        if (emails.isPresent()) {
            if (emails.get().contains(email)) {
                System.out.println(("User already registered with this email"));
                return null;
            }
        }

        UniqueNumber userId = new UniqueNumber();
        long userIdNum = userId.getID();
        User newUser = new User(userIdNum, name, email, password);
        repository.writeUser(newUser);
        System.out.println("user registered successfully");
        return newUser;
    }

    public Long logIn(String email, String password) {

        Optional<User> user =  repository.getUserByEmail(email);

        if (!user.isPresent()) {
            System.out.println(String.format("User with email %s doesn't exists.", email));
        }
        if (!user.get().getPassword().equals(password)) {
            System.out.println("Wrong password for given!");
        }

        Long token;
        do {
            token = tokenUniqueNumber.getID();
        } while (tokenSet.contains(token));
        tokenService.setSession(token, user.get().getId());
        return token;
    }
}