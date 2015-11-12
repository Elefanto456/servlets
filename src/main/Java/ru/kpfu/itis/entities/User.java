package ru.kpfu.itis.entities;

public class User {
    private String email;
    private String password;
    private String gender;
    private String subscription;
    public  User(String s, String s1, String s2, String s3, String s4){};
    public User(String email, String password, String gender, String subscription) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.subscription = subscription;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(){
        this.password = password;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(){
        this.gender = gender;
    }

    public String getSubscription(){
        return subscription;
    }

    public void setSubscription(String off){
        this.subscription = subscription;
    }
}
