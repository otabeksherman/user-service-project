package App.controller;
import App.service.AuthenticationService;
import App.service.UserService;

import static App.controller.UtilController.*;

public class UserController {
    private static UserService userService= new UserService();

    public static void updateUserEmail(long id,Long token, String email){
        if(!checkEmailValid(email)){
            System.out.println("email invalid");
        }else {
            userService.updateEmail(id,token, email);
        }
    }
    public static void updateUserName(long id,Long token,String name){
        if(!checkNameValid(name)){
            System.out.println("name invalid");
        }else {
            userService.updateName(id,token,name);
        }

    }public static void updateUserPassword(long id,Long token,String password){
        if(!checkPasswordValid(password)){
            System.out.println("password invalid");
        }else {
            userService.userUpdatePassword(id ,token,password);
        }
    }
    public static void deleteUser(long id,Long token){
        userService.deleteUser(id,token);
    }

}
