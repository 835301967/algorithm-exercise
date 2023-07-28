package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LineReadWriteExample {
    public static void main(String[] args) {
        String sourceFile = "source/file.txt";
        String destinationFile = "destination/file.txt";

        // 逐行读取源文件并逐行写入目标文件
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // 写入换行符
            }
            System.out.println("文件逐行读写完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

