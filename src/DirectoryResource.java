import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class DirectoryResource {
    public File[] selectMultipleFiles(){
        File[] selectedFiles = null;
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setMultiSelectionEnabled(true);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Get selected files
            selectedFiles = fileChooser.getSelectedFiles();
        }
        return selectedFiles;
    }

    public ArrayList<String> getFilePaths(File[] selectedFiles){
        ArrayList<String> filePaths = new ArrayList<>();
        DirectoryResource directory = new DirectoryResource();
        File[] files = directory.selectMultipleFiles();
        for (File file : files){
            String filepath = file.getAbsolutePath();
            filePaths.add(filepath);
        }
        return filePaths;
    }
}
