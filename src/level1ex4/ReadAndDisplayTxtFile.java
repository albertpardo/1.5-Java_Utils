package level1ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadAndDisplayTxtFile {

    private static void readAndDisplayTxtFile(File fileObj){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileObj))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading the file: " + fileObj, e);
        }
    }

    public static void main(String[] args){
        try {
            if (args.length != 1)
                throw new RuntimeException("Only one argument is valid!!");
            File fileObject = new File(args[0]);
            if (!fileObject.exists() && !fileObject.isFile())
                throw new RuntimeException(args[0] + ": It's not a file or it does not exist!!");
            readAndDisplayTxtFile(fileObject);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
