package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private static boolean checkEmailValid(String email){
        if (email == null) {
            System.out.println("Email field is empty");
            return false;
        }
        return  checkRegex("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"
                ,email);
    }
    private static  boolean checkNameValid(String name){
        if (name == null) {
            System.out.println("User name field is empty");
            return false;
        }
        return  checkRegex("[A-Z]+[a-z]+",name);
    }
    private static boolean checkPasswordValid(String password) {
        if (password == null) {
            System.out.println("password field is empty");
            return false;
        }
       return checkRegex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", password);
    }
    private static boolean checkRegex(String regex, String name){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        return m.matches();
    }

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

        //User newUser= createUser(name, email,password);// not connect yet( belong to service method)


        //service method to create user
        //notify to client new user created. (print)
    }

}
