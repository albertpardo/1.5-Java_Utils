package level1ex2;

import java.io.File;
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

    private static void printAsDirOrFile(String pathname, String fileName){
        String newPathName = pathname + fileName;
        String typeFile = "";

        try {
            File fileObject = new File(pathname);
            if (fileObject.isDirectory())
                typeFile = "(D)";
            if (fileObject.isFile())
                typeFile = "(F)";
            long lastModified = fileObject.lastModified();

            Instant instant = Instant.ofEpochMilli(lastModified);
            LocalDateTime date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            System.out.println(fileName + " " +  typeFile + " " + date);
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
                System.out.println(MSG_SHOW_FILE_LIST);
                for (String fileName : filesArrayList) {
                    printAsDirOrFile(pathname, fileName);
                }
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
