package day00004.filesAndIO.Directory;

import java.io.File;

public class CreateDirectories {
    public static void main(String[] args) {
        String nameDir="OutputStreams";
        File file = new File(nameDir);
        String rootPath = file.getAbsolutePath().substring(0,file.getAbsolutePath().length()-(nameDir.length())-1);
        String outPath = rootPath+"\\Java\\Learning\\src\\day00004\\filesAndIO\\Directory\\";
        File newDir=new File(outPath+nameDir);
        if(!newDir.exists()){
            newDir.mkdirs();
            System.out.println("succeeded to create new directory in path: "+newDir.getAbsolutePath());
        }else {
            newDir.delete();
            System.out.println("Dir was already exists");
        }

    }
}
