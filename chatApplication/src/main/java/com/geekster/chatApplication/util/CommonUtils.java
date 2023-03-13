package com.geekster.chatApplication.util;
import java.util.regex.*;
public class CommonUtils {

    public static  boolean isValidPassword(String password){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        return m.matches();
        /*
        It contains at least 8 characters and at most 20 characters.
        It contains at least one digit.
        It contains at least one upper case alphabet.
        It contains at least one lower case alphabet.
        It contains at least one special character which includes !@#$%&*()-+=^.
        It does’t contain any white space.
        */
    }
    public static boolean isValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile("(0|91)?[6-9][0-9]{9}");

        Matcher m = p.matcher(phoneNumber);
        return (m.find() && m.group().equals(phoneNumber));
    }
}
