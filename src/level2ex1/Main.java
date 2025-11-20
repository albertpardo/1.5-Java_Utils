package level2ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main{

    private static final String OUTPUT_FILE_NAME = "directoriesInfo.txt";
    private static final String PROPERTIES_CONFIG_FILE = "level2ex1/resources/config.properties";
    private static String pathname;
    private static String outputFileName;

    private static void getDataFromPropertiesConfigFile() {
        final String INPUT_DIR = "input.directory";
        final String OUTPUT_FILE = "output.file";

        Properties properties = new Properties();

        try(InputStream inputStream = new FileInputStream(PROPERTIES_CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        pathname = properties.getProperty(INPUT_DIR);
        outputFileName = properties.getProperty(OUTPUT_FILE);

        if(pathname == null || pathname.trim().isEmpty() || outputFileName == null || outputFileName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "A property doesn't found in " + PROPERTIES_CONFIG_FILE);
        }

        System.out.println("Load configuration:");
        System.out.println("  input.directory = " + pathname);
        System.out.println("  output.file     = " + outputFileName);
    }

    public static void main(String[] args){

        try{
            getDataFromPropertiesConfigFile();
            ShowSortedFilesFromAGivenPath.writeDirContentNamesToTxt(pathname, outputFileName);
            System.out.println("Generated file can be found with the path : " + outputFileName);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
