import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            File folder = new File(args[0]);

            FilenameFilter fileFilter = (dir, name) -> name.endsWith(".swift");
            File[] files = folder.listFiles(fileFilter);

            FileWriter fw = new FileWriter("metrics.csv");

            for (File file : files) {
                fw.write(file.getName() + ',');
                try {
                    JavaSwift.parse(args[0] + file.getName());
                    System.out.println(Metrics.INSTANCE.classCount);
                    Metrics.INSTANCE.clear();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                fw.write('\n');
            }

            fw.close();
            System.out.println("Report had been generated successfully!");
        } catch (NoSuchFileException e) {
            System.out.println("Sorry, could not find such folder.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please, don't forget to pass name of directory with sources as an argument.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
