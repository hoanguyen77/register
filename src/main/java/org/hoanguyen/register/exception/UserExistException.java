package org.hoanguyen.register.exception;

public class UserExistException extends Exception{
    public UserExistException(String message){
        super(message);
    }
}
