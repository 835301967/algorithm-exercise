package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamExample {
    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("当前工作目录：" + currentDirectory);
        String sourceFile = "./source/file.txt";
        String destinationFile = "./destination/file.txt";

        // 读取文件并写入到目标文件
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("文件复制完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

