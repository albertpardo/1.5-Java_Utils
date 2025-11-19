package level1ex5;

import java.io.*;
import java.nio.file.Paths;

public class SerializerTestInJava {
    private static final String SER_FILE_NAME = "personOne.ser";
    private static final String RESOURCES_DIR = "level1ex5/resources";

    private static void deserializerStep(String serPath){
        PersonName name;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serPath))) {
            name = (PersonName) ois.readObject();
            System.out.println("Deserializer Done!!. Here is the info with 'name.toString()'");
            System.out.println(name.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("ERROR : " + e.getMessage());
        }
    }

    private static void serializerStep(String serPath) {
        PersonName name1 = new PersonName("Name One");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serPath, false))) {
            oos.writeObject(name1);
            System.out.println("Serialized done!!");
        } catch (IOException e) {
            System.err.println("ERROR : " + e.getMessage());
        }
    }

    public static void main(String[] args){
        File resourceFileDir = new File(RESOURCES_DIR);
        String serPath = String.valueOf(Paths.get(resourceFileDir.getAbsolutePath(), SER_FILE_NAME));
        serializerStep(serPath);
        deserializerStep(serPath);
    }
}
