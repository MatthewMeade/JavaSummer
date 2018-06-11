import java.io.*;
import java.util.Scanner;

/**
 * Class used to demonstrate file writing functionality
 */
public class WriteFile {

    private static final String OUTPUT_DIR = "files/output/";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter filename: ");
        String fileName = scanner.nextLine();

        System.out.printf("Enter line of text to store in %s: ", fileName);
        String input = scanner.nextLine();

        try {
            File dir = new File(OUTPUT_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(OUTPUT_DIR + fileName);

            FileWriter writer = new FileWriter(file.getAbsoluteFile());
            writer.write(input);
            writer.close();

            System.out.printf("\nFile Name:\t\t%s\nAbsolute Path:\t%s\nFile Length:\t%s\n", file.getName(), file.getAbsoluteFile(), file.length());

        } catch (IOException e) {
            System.out.println("Error, could not write to file " + fileName + "\n" + e.getMessage());
        }

    }
}
