package ExceptionH;
import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String source = "src/ExceptionH/source.txt";
        String destination = "src/ExceptionH/destination.txt";

        try (BufferedReader re = new BufferedReader(new FileReader(source));
             BufferedWriter wr = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = re.readLine()) != null) {
                wr.write(line);
                wr.newLine();
            }
            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
             System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println("IO exception"+e.getMessage());
        }
    }
}
