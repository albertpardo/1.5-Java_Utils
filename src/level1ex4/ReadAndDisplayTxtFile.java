package level1ex4;


import java.io.File;

public class ReadAndDisplayTxtFile {

    private static void readAndDisplayTxtFile(File fileObj){

    }
    public static void main(String[] args){

        if (args.length == 1){
            File fileObject = new File(args[0]);
            if (fileObject.exists() && fileObject.isFile())
                readAndDisplayTxtFile(fileObject);
            else
                System.err.println("It's not a file or not exist!!");
        }
        else
            System.err.println("Only one argument is valid!!");
    }


}
