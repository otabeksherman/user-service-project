package App.client;

import App.User;
import App.controller.AuthController;
import App.controller.UserController;

import java.util.OptionalLong;

public class Main {
    public static void main(String[] args) {

        //register new user
        long id=AuthController.registerNewUser("Avi","avi@gmail.com","Avi123456");

        //login
        Long token=AuthController.login ("avi@gmail.com","Avi123456");
        //update name:
        UserController.updateUserName(token,"Ron");
        //update email:
        UserController.updateUserEmail(token,"Ron@gmail.com");
        //update password:
        UserController.updateUserPassword( token,"Ron123456");

        //delete user:
        UserController.deleteUser(token);

    }
}
