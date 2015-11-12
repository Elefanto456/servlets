package ru.kpfu.itis.repositories;

import ru.kpfu.itis.entities.User;
import ru.kpfu.itis.exceptions.*;
import ru.kpfu.itis.utils.Db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRepository {
    private static String dataBase = "dataBase";
    private static File db = new File("C:/Users/Acer/Documents/web/myProject/src/main/Java/DataBase.txt");

    private static void duplicatesCheck(User user) throws DuplicateEntryException, DatabaseException{
        for (User userEntry : getAll()  ) {
            if(userEntry.getEmail().equals(user.getEmail()))
                throw new DuplicateEntryException("This user already exists!");
        }
    }

    public static void addUser(User user) throws NotValidEmailException, DatabaseException, DuplicateEntryException, NotValidPasswordException {
        duplicatesCheck(user);
        emailCheck(user.getEmail());
        passwordCheck(user.getPassword());
        if(user.getSubscription()==null){
            user.setSubscription("off");
        }
        try {
            Db.addEntry(dataBase, new String[]{user.getEmail(), user.getPassword(), user.getGender()});

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }

    public static User identifyUser(String email, String password) throws DatabaseException, IdentificationException, IdentificationException {
        for (User userEntry : getAll()) {
            if (userEntry.getEmail().equals(email) && userEntry.getPassword().equals(password))
                return userEntry;
        }
        throw new IdentificationException("No such user");
    }

    public static List<User> getAll() throws DatabaseException {
        List<String[]> entries = Db.getAllEntries(dataBase);
        List<User> users = new ArrayList<>();
        for (String[] entry : entries) {
            User user = new User(entry[0], entry[1], entry[2], entry[3], entry[4]);
            users.add(user);
        }
        return users;
    }

    private static boolean passwordCheck(String password) throws NotValidPasswordException {
        if (password == null || password.length() < 6 || password.length() > 15) {
            return false;
        }
        return true;
    }

    private static boolean emailCheck(String email) throws NotValidEmailException {
        Pattern pattern = Pattern.compile("\\\\w+([\\\\.-]?\\\\w+)*@\\\\w+([\\\\.-]?\\\\w+)*\\\\.\\\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}