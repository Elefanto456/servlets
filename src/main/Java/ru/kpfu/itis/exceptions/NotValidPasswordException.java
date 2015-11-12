package ru.kpfu.itis.exceptions;

public class NotValidPasswordException extends Exception{
    public NotValidPasswordException(String message) {
        super(message);
    }
}
