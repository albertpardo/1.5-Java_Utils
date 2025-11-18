package level1ex4;


import java.io.File;

public class ReadAndDisplayTxtFile {

    private static void readAndDisplayTxtFile(File fileObj){

    }
    public static void main(String[] args){

        /*
        if (args.length == 1){
            File fileObject = new File(args[0]);
            if (fileObject.exists() && fileObject.isFile())
                readAndDisplayTxtFile(fileObject);
            else
                System.err.println("It's not a file or not exist!!");
        }
        else
            System.err.println("Only one argument is valid!!");

         */

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
