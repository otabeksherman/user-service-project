package App.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static App.controller.UtilController.*;

public class UserController {



    public static void registerNewUser( String email, String name, String password){
        if(!checkEmailValid(email)){
            System.out.println("email field invalid");
            return;
        }
        if(!checkNameValid(name)){
            System.out.println("name field invalid");
            return;
        }
        if(!checkPasswordValid(password)){
            System.out.println("password must include minimum eight characters, at least one letter and one number");
            return;
        }

        //App.User newUser= createUser(name, email,password);// not connect yet( belong to service method)


        //service method to create user
        //notify to App.client new user created. (print)
    }

}
