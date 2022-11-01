package App.client;

import App.User;
import App.controller.AuthController;
import App.controller.UserController;

import java.util.OptionalLong;

public class Main {
    public static void main(String[] args) {

        //register new user
        User user=AuthController.registerNewUser("Avi","avi@gmail.com","Avi123456");
        //print user:
        System.out.println(user.toString());

        //login
        long id= user.getId();
        Long token=AuthController.login ("avi@gmail.com","Avi123456");
        //update name:
        UserController.updateUserName(id, token,"Ron");
        //update email:
        UserController.updateUserEmail(id, token,"Ron@gmail.com");
        //update password:
        UserController.updateUserPassword(id, token,"Ron123456");

        //print user:
        System.out.println(user.toString());
        //delete user:
        UserController.deleteUser(id, token);

    }
}
