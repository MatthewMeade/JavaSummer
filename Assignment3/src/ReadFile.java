import java.io.*;
import java.util.Scanner;

/**
 * Class used to demonstrate reading a file
 */
public class ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file directory: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter filename: ");
        String fileName = scanner.nextLine();

        try {
            System.setErr(new PrintStream("./files/Error.txt"));

            File path = new File(filePath);
            if (!path.exists()) {
                System.err.printf("Error: Directory %s does not exist\n", filePath);
                return;
            }

            File file = new File(path.getAbsolutePath() + "/" + fileName);
            if (!file.exists()) {
                System.err.printf("Error: File %s does not exist\ns", file.getAbsolutePath());
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            } while (line != null);

            reader.close();

            System.out.printf("\nFile Name:\t\t%s\nAbsolute Path:\t%s\nFile Length:\t%s\n", file.getName(), file.getAbsoluteFile(), file.length());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
