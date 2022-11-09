package App.controller;
import App.service.UserService;
import App.utilities.Debugger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static App.controller.UtilController.*;

public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class.getName());

    private static UserService userService= new UserService();

    public static void updateUserEmail(Long token, String email){
        if (!checkEmailValid(email)){
            logger.warn("Invalid Email for update");
        } else {
            userService.updateEmail(token, email);
        }
    }

    public static void updateUserName(Long token,String name){
        if (!checkNameValid(name)){
            logger.warn("Invalid Name for update");
        } else {
            userService.updateName(token, name);
        }
    }

    public static void updateUserPassword(Long token,String password){
        if(!checkPasswordValid(password)){
            logger.warn("Invalid Password for update");
        } else {
            userService.userUpdatePassword(token, password);
        }
    }

    public static void deleteUser(Long token){
        userService.deleteUser(token);
    }
}
