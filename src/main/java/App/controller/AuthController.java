package App.controller;

import App.service.AuthenticationService;

import java.util.Optional;
import java.util.OptionalLong;

import static App.controller.UtilController.*;

public class AuthController {
    public Long login(String email, String password){
        if(!checkEmailValid(email)){
            System.out.println("email field invalid");
            return null;
        }
        if(!checkPasswordValid(password)){
            System.out.println("password must include minimum eight characters, at least one letter and one number");
            return null;
        }

        AuthenticationService service=new AuthenticationService();
        return service.loginUser(email,password);// need changes to email and password

    }


}
