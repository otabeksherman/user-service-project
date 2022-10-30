import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class Repository {

    private static final String USERS_REPO_PATH = "src/main/java/Repository/users/";

    void writeUser(User user) {
        Gson gson = new Gson();
        String filePath = USERS_REPO_PATH + user.getId();
        try(FileWriter fileWriter = new FileWriter(filePath)) {
            gson.toJson(user, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
