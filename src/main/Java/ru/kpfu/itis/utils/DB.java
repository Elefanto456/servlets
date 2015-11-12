package ru.kpfu.itis.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import ru.kpfu.itis.exceptions.DatabaseException;


public class Db {

    private final static String extension = "db";
    private final static String path = "C:\\Users\\Baths\\Documents\\web\\";

    private static void checkDb(String db) throws DatabaseException {
        File f = new File(getDbFullPath(db));
        if (!f.exists() || !f.isFile() || !f.canRead() || !f.canWrite()) {
            throw new DatabaseException();
        }
    }

    private static String getDbFullPath(String db) {
        String fullName = db + "." + extension;
        String fullPath = path + fullName;
        return fullPath;
    }

    public static void addEntry(String db, String[] data) throws DatabaseException {
        checkDb(db);
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(getDbFullPath(db),true));
            writer.writeNext(data);
            writer.close();
        } catch (IOException ex) {
            throw new DatabaseException();
        }
    }

    public static List<String[]> getAllEntries(String db) throws DatabaseException {
        checkDb(db);
        try {
            CSVReader reader = new CSVReader(new FileReader(getDbFullPath(db)));
            return reader.readAll();
        } catch (IOException ex) {
            throw new DatabaseException();
        }
    }

}