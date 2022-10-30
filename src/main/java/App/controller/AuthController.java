package App.controller;

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

        //AuthService service=new AuthService();
        //return service.login(email,password);
        return null;//remove that after get AuthService
    }


}
