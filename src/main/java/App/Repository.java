package App;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class Repository {

    private static final String USERS_REPO_PATH = "src/main/java/App.Repository/users/";
    /*
    user class needs to be in repo
    private Map<Integer, User> users;
    public void updateUser(User user){
    if(user.containsKey(user.is){
        users.put(user.id, user);
        }
    }
    private void writeToFile(String filename, User content){
    }
    private User readFromFile(String filename){
    return new User();
    }
     */

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
