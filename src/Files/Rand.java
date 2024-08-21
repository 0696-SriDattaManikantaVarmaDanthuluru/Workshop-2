package Files;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Rand {
    public static void main(String[] args) {
        String inputFilePath = "src/Files/in2.txt";
        String outputFilePath = "src/Files/out.txt";


        try (RandomAccessFile inputFile = new RandomAccessFile(inputFilePath, "r")) {
            inputFile.seek(0);
            String message = inputFile.readUTF();
            int number = inputFile.readInt();
            double pi = inputFile.readDouble();


            try (RandomAccessFile outputFile = new RandomAccessFile(outputFilePath, "rw")) {
                outputFile.writeUTF(message);
                outputFile.writeInt(number);
                outputFile.writeDouble(pi);
            } catch (IOException e) {
                System.err.println("Error writing to output file: " + e.getMessage());
            }

            System.out.println("Data successfully read from input file and written to output file.");
        } catch (EOFException e) {
            System.err.println("Reached end of input file unexpectedly: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading from input file: " + e.getMessage());
        }
    }
}
