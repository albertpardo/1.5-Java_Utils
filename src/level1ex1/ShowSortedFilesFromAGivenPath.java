package level1ex1;

import java.io.File;

public class ShowSortedFilesFromAGivenPath {
    public static void showSortedFiles(String pathname){
     //from https://www.geeksforgeeks.org/java/file-list-method-in-java-with-examples/
        // try-catch block to handle exceptions
        try {

            // Create a file object
            File f = new File(pathname);

            // Get all the names of the files present
            // in the given directory
            String[] files = f.list();

            System.out.println("Files are:");

            // Display the names of the files
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
