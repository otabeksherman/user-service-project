package App.controller;

import App.service.AuthenticationService;
import App.utilities.Debugger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static App.controller.UtilController.*;

public class AuthController {


    private static AuthenticationService authService= new AuthenticationService();


    private static Logger logger = LogManager.getLogger(AuthController.class.getName());


    public static Long registerNewUser(String email, String name, String password){
        if(!checkEmailValid(email)){
            logger.warn("Invalid Email");
            return null;
        }
        if(!checkNameValid(name)){
            logger.warn("Invalid Name");
            return null;
        }
        if(!checkPasswordValid(password)){
            logger.warn("Invalid Password. Must include minimum eight characters, " +
                    "at least one letter and one number");
            return null;
        }

        return authService.createUser(email, name, password);
    }

    public static Long login(String email, String password){
        if(!checkEmailValid(email)){
            logger.warn("Email field invalid");
            return null;
        }

        Long token = authService.logIn(email, password);
        logger.info("Logged In Successfully");
        return token;
    }
}
