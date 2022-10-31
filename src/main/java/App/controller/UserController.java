package App.controller;
import App.service.AuthenticationService;

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


        //add that after merge with userService
        /*
         newUser= createUser(name, email,password);
        if(newUser.get() != null){
            System.out.println("Create user successfully");
        }*/
    }

    public static void updateUserEmail(Long id,String email){
        if(!checkEmailValid(email)){
            System.out.println("email invalid");
        }else {

        AuthenticationService.updateEmail(id, email);

        }
    }
    public static void updateUserName(Long id,String name){
        if(!checkNameValid(name)){
            System.out.println("name invalid");
        }else {

        AuthenticationService.updateName(id, name);

        }

    }public static void updateUserPassword(Long id,String password){
        if(!checkPasswordValid(password)){
            System.out.println("password invalid");
        }else {

        AuthenticationService.userUpdatePassword(id ,password);

        }
    }
    public static void deleteUser(String email, String password){
        if(!(checkEmailValid(email)|| !(checkPasswordValid(password)))){
            System.out.println("email/password invalid!");
        }

        AuthenticationService.deleteUser(id,password);


    }

}
