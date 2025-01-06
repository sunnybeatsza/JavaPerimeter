import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class DirectoryResource {
    // Method to allow the user to select multiple files using JFileChooser
    public File[] selectMultipleFiles() {
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

    // Method to convert selected files to a list of file paths
    public ArrayList<String> getFilePaths(File[] selectedFiles) {
        ArrayList<String> filePaths = new ArrayList<>();

        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                filePaths.add(file.getAbsolutePath());
            }
        }

        return filePaths;
    }

}
