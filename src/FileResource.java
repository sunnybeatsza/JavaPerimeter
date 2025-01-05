import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileResource {
    ArrayList<String> points = new ArrayList<>();
    String filePath;

    public FileResource(String filePath) throws IOException {
        this.filePath = filePath;
        this.points = readFile(filePath);
    }
    public ArrayList<String> readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null){
            points.add(line);
        }
        reader.close();
        return points;
    }


}
