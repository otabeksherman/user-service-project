package App.service;

import App.User;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repository {

    private static Repository instance;

    private static final String USERS_REPO_PATH = "src/main/java/App/Repository/users/";

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private HashMap<Long, User> users;

    private Repository() {
        this.users = new HashMap<>();
        initUsers();
    }

    void writeUser(User user) {
        Gson gson = new Gson();
        String filePath = USERS_REPO_PATH + user.getId();
        try(FileWriter fileWriter = new FileWriter(filePath)) {
            gson.toJson(user, fileWriter);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Optional<List<String>> getEmails() {
        return Optional.of(users.values().stream()
                .map(User::getEmail)
                .collect(Collectors.toList()));
    }

    Optional<User> getUserById(long id) {
        return Optional.of(users.get(id));
    }

    Optional<User> getUserByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    void updateUser(User user) {
        users.put(user.getId(), user);
        writeUser(user);
    }

    boolean deleteUser(User user) {
        users.remove(user.getId());
        Path path = Paths.get(USERS_REPO_PATH + user.getId());
        try {
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initUsers() {
        Optional<List<String>> filePaths = getFilePaths();
        if (!filePaths.isPresent()) {
            return;
        }
        Gson gson = new Gson();
        for (String path : filePaths.get()) {
            try(BufferedReader reader = new BufferedReader(new FileReader(path));) {
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                // delete the last new line separator
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                User user = gson.fromJson(stringBuilder.toString(), User.class);
                this.users.put(user.getId(), user);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Optional<List<String>> getFilePaths() {
        List<String> paths;
        try (Stream<Path> stream = Files.list(Paths.get(USERS_REPO_PATH))) {
            paths = stream
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(paths);
    }
}
