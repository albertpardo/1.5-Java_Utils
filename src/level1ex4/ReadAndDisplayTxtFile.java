package level1ex4;

public class ReadAndDisplayTxtFile {

    public static void main(String[] args){

        switch (args.length) {
            case 1:
                ShowSortedFilesFromAGivenPath.writeDirContentNamesToTxt(args[0]);
                break;
            case 0:
                System.err.println("No arguments!!");
                break;
            default:
                System.err.println("Many arguments are not allowed!!");
                break;
        }
    }


}
