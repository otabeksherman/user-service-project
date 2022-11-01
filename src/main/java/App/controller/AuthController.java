package App.controller;

import App.service.AuthenticationService;

import static App.controller.UtilController.*;

public class AuthController {


    private static AuthenticationService authService= new AuthenticationService();

    public static Long registerNewUser(String email, String name, String password){
        if(!checkEmailValid(email)){
            System.out.println("email field invalid");
            return null;
        }
        if(!checkNameValid(name)){
            System.out.println("name field invalid");
            return null;
        }
        if(!checkPasswordValid(password)){
            System.out.println("password must include minimum eight characters, at least one letter and one number");
            return null;
        }

        return authService.createUser(name, email, password);
    }

    public static Long login(String email, String password){
        if(!checkEmailValid(email)){
            System.out.println("email field invalid");
            return null;
        }
        if(!checkPasswordValid(password)){
            System.out.println("password must include minimum eight characters, at least one letter and one number");
            return null;
        }
        Long token=authService.logIn(email, password);
        return token;
    }


}
