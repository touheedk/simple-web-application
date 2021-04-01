package com.touheedkhan;

public class UserValidataionService {

    public boolean isUserValid(String user, String password) {
        if(user.equals("touheed") && password.equals("touheed123"))
            return true;
        return false;
    }
}
