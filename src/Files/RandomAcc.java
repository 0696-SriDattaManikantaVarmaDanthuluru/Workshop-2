package Files;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcc {
    public static void main(String[] args) {
        String filePath = "src/Files/in2.txt";
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.writeBytes("Hello World\n");
            raf.writeBytes("22\n");
            raf.writeBytes("3.1419\n");

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            raf.seek(0);
            String message = raf.readLine();
            int number = Integer.parseInt(raf.readLine());
            double pi =  Double.parseDouble(raf.readLine());

            System.out.println("Read message: " + message);
            System.out.println("Read number: " + number);
            System.out.println("Read double: " + pi);
        } catch (EOFException e) {
            System.err.println("Reached end of file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
