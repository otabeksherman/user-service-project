package App.client;

import App.User;
import App.controller.AuthController;
import App.controller.UserController;

import java.util.OptionalLong;

public class Main {
    public static void main(String[] args) {

        //register new user
        AuthController.registerNewUser("avi@gmail.com","Avi","Avi123456");
        AuthController.registerNewUser("yossi@gmail.com","Yossi","Yos123456");

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
