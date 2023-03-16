package day00004.filesAndIO.Stream;

import java.io.*;

public class CharacterStream {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        File input = new File("einput.txt");
        File output = new File("eoutput2.txt");


        try{
            fileReader = new FileReader(input.getAbsolutePath());
            fileWriter = new FileWriter(output);

            int copy;
            while ((copy = fileReader.read()) != -1) {
                fileWriter.write(copy);
            }
            System.out.println("file input was succeed to copied in: " + output.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
