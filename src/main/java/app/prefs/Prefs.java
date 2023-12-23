package app.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DB_JDBC_CONNECTION_URL = "dbUrl";
    public static final String INIT_DB_SQL_FILE_PATH =  "initDbSql";
    public static final String POPULAR_DB_SQL_FILE_PATH =  "popularServ";
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    public static final String FIND_MAX_PROJECT_CLIENT = "maxProjectsClient";
    public static final String FIND_LONGEST_PROJECT = "longestProject";
    public static final String FIND_MAX_SALARY_WORKER = "maxSalaryWorker";
    public static final String FIND_YOUNGEST_ELDEST_WORKERS = "youngestEldestWorkers";
    public static final String PRINT_PROJECT_PRICES = "projectPrices";


    private Map<String, Object> prefs = new HashMap<>();
    public Prefs() {
        this(DEFAULT_PREFS_FILENAME);
    }
    public Prefs(String filename) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class);
            prefs = new Gson().fromJson(reader, typeToken.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getString(String key){
        return getPref(key).toString();
    }
    public Object getPref(String key){
        return prefs.get(key);
    }

}
