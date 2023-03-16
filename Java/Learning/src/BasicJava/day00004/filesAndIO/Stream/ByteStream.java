package BasicJava.day00004.filesAndIO.Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        File fileInput = new File("einput.txt");
        File fileOutput = new File("eoutput.txt");

        try {
            inputStream = new FileInputStream(fileInput.getAbsolutePath());
            fileOutputStream = new FileOutputStream(fileOutput);

            int copy;
            while ((copy = inputStream.read()) != -1) {
                fileOutputStream.write(copy);
            }
            System.out.println("fileInput was succeeded copied to: " + fileOutput.getAbsolutePath());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
