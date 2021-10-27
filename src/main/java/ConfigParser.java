import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ConfigParser {
    private String fileName;
    private String pathName;
    private Map<String, String> mapKeys = new HashMap<>();

    public ConfigParser(String fileName) {
        this.fileName = fileName;
        this.pathName = getPathName(this.fileName);
        this.mapKeys = getMapKeys(this.pathName);
    }

    private String getPathName(String filename) {
        String environment = filename;

        if (filename.length() < 1) {
            fileName = "src/main/java/config.txt";
        } else {
            switch (environment) {
                case "staging":
                    pathName = "src/main/java/config.txt.staging";
                    break;
                case "development":
                    pathName = "src/main/java/config.txt.dev";
                    break;
                default:
                    pathName = "src/main/java/config.txt";
            }
        }
        return pathName;
    }

    private Map<String, String> getMapKeys (String pathName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(pathName));) {
            String rd;
            String [] line;
            String application = "";
            int count = 1;
            while ((rd = reader.readLine()) != null) {
                if (rd.trim().isEmpty()) {
                    application = "";

                } else {
                    if (rd.contains("application")) {
                        application = "application" + count + ".";
                        count++;
                    }
                    else {
                        line = rd.split("=");
                        mapKeys.put(application + line[0], line[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapKeys;
    }

    public String getValue(String key) {
        if (mapKeys.get(key) == null) {
            return "Invalid key";
        } else {
            return mapKeys.get(key);
        }
    }
}

