package ru.kpfu.itis.exceptions;

public class NotValidEmailException extends Exception{
    public NotValidEmailException(String s) {
        super(s);
    }
}
