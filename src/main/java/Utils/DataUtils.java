package Utils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;

public class DataUtils {

    public static String filePath = "src/test/resources/TestData/" ;

    //TODO:: read data from json file
    public static String readJsonFile(String fileName , String key) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(filePath + fileName + ".json"));
        JsonElement js = new Gson().fromJson(reader, JsonElement.class);
        return js.getAsJsonObject().get(key).getAsString();
    }


    //TODO :: read data from properties file
    public static String  readPropertiesFile(String fileName , String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath + fileName + ".properties"));
        return properties.getProperty(key);
    }

}
