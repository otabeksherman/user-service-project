package App.controller;
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

    public static void updateUserEmail(String email, Long token){
        if(!checkEmailValid(email)){
            System.out.println("email invalid");
        }else {
        /*
        UserService.updateUserEmail(email,token);
         */
        }
    }
    public static void updateUserName(String name, Long token){
        if(!checkNameValid(name)){
            System.out.println("name invalid");
        }else {
        /*
        UserService.updateUserName(name,token);
         */
        }

    }public static void updateUserPassword(String password, Long token){
        if(!checkPasswordValid(password)){
            System.out.println("password invalid");
        }else {
        /*
        UserService.updateUserPassword(password,token);
         */
        }
    }
    public static void deleteUser(String email, String password,Long token){
        if(!(checkEmailValid(email)|| !(checkPasswordValid(password)))){
            System.out.println("email/password invalid!");
        }
        /*
        UserService.deleteUser(email,password,token);
         */

    }

}
