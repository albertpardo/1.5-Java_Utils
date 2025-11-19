package level2ex1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ShowSortedFilesFromAGivenPath {
    static final String MSG_NO_EXIST = "Path not Exist!!";
    static final String MSG_NO_DIR = "This is not a directory!!";
    private static final String OUTPUT_FILE_NAME = "directoriesInfo.txt";

    private static LocalDateTime getLastModified(File fileObj){
        long lastModified;
        Instant instant;

        lastModified = fileObj.lastModified();
        instant = Instant.ofEpochMilli(lastModified);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    private static  String getTypeFile(File fileObject){
        if (fileObject.isDirectory())
            return "(D)";
        else if (fileObject.isFile())
            return "(F)";
        return "(x)";
    }

     private static void writeToTxt(String pathname, ArrayList<String> filesArrayList, PrintWriter writerObject){
        try {
            Path newPathName;
            File fileObject;
            String typeFile;
            LocalDateTime date;

            for (String fileName : filesArrayList) {
                newPathName = Paths.get(pathname, fileName);
                fileObject = new File(newPathName.toUri());
                typeFile = getTypeFile(fileObject);
                date = getLastModified(fileObject);
                writerObject.println(fileName + " " + typeFile + " " + date);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
     }

     private static void goToInnerDir(String pathname, ArrayList<String> filesArrayList, PrintWriter writerObject) {
        try {
            Path newPathName;
            File fileObject;

            for (String fileName : filesArrayList) {
                newPathName = Paths.get(pathname, fileName);
                fileObject = new File(newPathName.toUri());
                if (fileObject.isDirectory())
                    writeToTxtProcess(String.valueOf(newPathName.toString()), writerObject);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void writeToTxtProcess(String pathname,PrintWriter writerObject){
        File fileObject = new File(pathname);
        String[] filesString;
        ArrayList<String> filesArrayList;

        if (!fileObject.exists()){
            System.err.println(MSG_NO_EXIST);
            return;
        }
        if (!fileObject.isDirectory()){
            System.err.println(MSG_NO_DIR);
            return;
        }
        filesString = fileObject.list();
        if (filesString != null) {
            filesArrayList = new ArrayList<>(Arrays.asList(filesString));
            Collections.sort(filesArrayList);
            writerObject.println("** Files in '" + pathname + "' (D) are:" );
            writeToTxt(pathname, filesArrayList, writerObject);
            goToInnerDir(pathname, filesArrayList, writerObject);
        }
    }

    public static void writeDirContentNamesToTxt(String pathname) {
        try (PrintWriter writerObject = new PrintWriter(new FileWriter(OUTPUT_FILE_NAME, false))){
            writeToTxtProcess(pathname, writerObject);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
