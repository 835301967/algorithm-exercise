package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.SortedMap;

/**
 * @Author yuxiangjin
 * @Date 2023/6/25 19:03
 **/
public class TestError {

    public static void main(String[] args) throws IOException {
        String string = new String(new char[] {111, 114, 97, 122, 103, 9, 53, 52, 10});
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("a.txt"));
        writer.write(string);
        writer.close();
    }
}
