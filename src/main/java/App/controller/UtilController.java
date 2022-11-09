package App.controller;

import App.utilities.Debugger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilController {
    private static Logger logger = LogManager.getLogger(UtilController.class.getName());

    static boolean checkEmailValid(String email){
        if (email == null) {
            logger.warn("Email field is empty");
            //System.out.println("Email field is empty");
            return false;
        }
        return  checkRegex("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"
                ,email);
    }
     static  boolean checkNameValid(String name){
        if (name == null) {
            logger.warn("App.User name field is empty");
            //System.out.println("App.User name field is empty");
            return false;
        }
        return  checkRegex("[A-Z]+[a-z]+",name);
    }

    static boolean checkPasswordValid(String password) {
        if (password == null) {
            logger.warn("password field is empty");
            //System.out.println("password field is empty");
            return false;
        }
        return checkRegex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", password);//regex expression: at least 8 character 1 letter and 1 digit
    }


    static boolean checkRegex(String regex, String name){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        return m.matches();
    }
}
