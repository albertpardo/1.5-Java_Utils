package level1ex2;

import java.io.File;
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
    static final String MSG_SHOW_FILE_LIST = "** Files are:";

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

    /*
    private static void printAsDirOrFile(String pathname, String fileName){
        try {
            Path newPathName = Paths.get(pathname, fileName);
            File fileObject = new File(newPathName.toUri());
            String typeFile= "(x)";
            LocalDateTime date;

            typeFile = getTypeFile(fileObject);
            date = getLastModified(fileObject);
            System.out.println(fileName + " " +  typeFile + " " + date);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
*/
    private static void printAsDirOrFile(String pathname, ArrayList<String> filesArrayList){
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
                System.out.println(fileName + " " + typeFile + " " + date);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /*
    private static void goToInnerDir(String pathname, String fileName) {
        try {
            Path newPathName = Paths.get(pathname, fileName);
            File fileObject = new File(newPathName.toUri());

            if (fileObject.isDirectory())
                showSortedFiles(String.valueOf(newPathName.toString()));
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
     */

    private static void goToInnerDir(String pathname, ArrayList<String> filesArrayList) {
        try {
            Path newPathName;
            File fileObject;

            for (String fileName : filesArrayList) {
                newPathName = Paths.get(pathname, fileName);
                fileObject = new File(newPathName.toUri());
                if (fileObject.isDirectory())
                    showSortedFiles(String.valueOf(newPathName.toString()));
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void showSortedFiles(String pathname){
        try {
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
                System.out.println("** Files in '" + pathname + "' (D) are:" );
                /*
                for (String fileName : filesArrayList) {
                    printAsDirOrFile(pathname, fileName);
                }*/
                printAsDirOrFile(pathname, filesArrayList);
                /*
                for (String fileName : filesArrayList) {
                    goToInnerDir(pathname, fileName);
                }
                */
                goToInnerDir(pathname, filesArrayList);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
