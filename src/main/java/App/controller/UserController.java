package App.controller;
import App.service.UserService;

import static App.controller.UtilController.*;

public class UserController {
    private static UserService userService= new UserService();

    public static void updateUserEmail(Long token, String email){
        if (!checkEmailValid(email)){
            System.out.println("Invalid Email for update");
        } else {
            userService.updateEmail(token, email);
        }
    }

    public static void updateUserName(Long token,String name){
        if (!checkNameValid(name)){
            System.out.println("Invalid Name for update");
        } else {
            userService.updateName(token, name);
        }
    }

    public static void updateUserPassword(Long token,String password){
        if(!checkPasswordValid(password)){
            System.out.println("Invalid Password for update");
        } else {
            userService.userUpdatePassword(token, password);
        }
    }

    public static void deleteUser(Long token){
        userService.deleteUser(token);
    }
}
