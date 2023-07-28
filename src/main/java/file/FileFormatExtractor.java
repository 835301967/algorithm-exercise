package file;

/**
 * @Author yuxiangjin
 * @Date 2023/6/19 11:33
 **/
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileFormatExtractor {
    public static void main(String[] args) {
        String filePath = "http://www.baiud.comjklj.png";
        String fileFormat = getFileFormat(filePath);
        System.out.println("File format: " + fileFormat);
        String filePath1 = "http://www.baiud.comjklj.jpeg";
        String fileFormat1 = getFileFormat(filePath1);
        System.out.println("File format: " + fileFormat1);
    }

    public static String getFileFormat(String filePath) {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
            return ""; // No file extension found
        }
        return fileName.substring(dotIndex + 1);
    }
}
