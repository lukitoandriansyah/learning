package BasicJava.day00004.filesAndIO.Directory;

import java.io.File;

public class ListingDirectory {
    public static void main(String[] args) {
        File file;
        String nameDir="Directory";
        file = new File(nameDir);
        String[] strings;
        try{
            String rootPath = file.getAbsolutePath().substring(0,file.getAbsolutePath().length()-(nameDir.length())-1);
            String outPath = rootPath+"\\Java\\Learning\\src\\day00004\\filesAndIO\\";
            file=new File(outPath+nameDir);

            strings=file.list();
            assert strings != null;
            for (String string : strings) {
                System.out.println(string);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
