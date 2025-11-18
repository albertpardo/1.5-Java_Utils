package level1ex1;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShowSortedFilesFromAGivenPath {
    static final String MSG_NO_EXIST = "Path not Exist!!";
    static final String MSG_NO_DIR = "This is not a directory!!";
    static final String MSG_SHOW_FILE_LIST = "** Files are:";

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
                for (String file : filesArrayList) {
                    System.out.println(file);
                }
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
