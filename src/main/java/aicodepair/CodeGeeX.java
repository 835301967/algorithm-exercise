package aicodepair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @Author yuxiangjin
 * @Date 2023/7/26 10:57
 **/
public class CodeGeeX {
    public static void main(String[] args) {

    }
    // 写一个读取 csv 文件的函数
    public static String[] readCsv(String filename) {
        return readCsv(filename, ',');
    }
    // 写一个读取 csv 文件的函数
    public static String[] readCsv(String filename, char delimiter) {
        try {
            Scanner sc = new Scanner(new FileReader(filename));
            sc.useDelimiter(String.valueOf(delimiter));
            String[] result = new String[sc.nextInt()];
            for (int i = 0; i < result.length; i++) {
                result[i] = sc.next();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 编写代码实现对身份证正则校验
    public static boolean checkId(String id) {
        if (id.length()!= 15)
            return false;
        boolean[] digit = new boolean[10];
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (c < '0' || c > '9')
                return false;
            digit[c - '0'] = true;
        }
        return digit[0] && digit[1] && digit[2] && digit[3] && digit[5] && digit[6] && digit[7] && digit[8] && digit[9];
    }
    // 编写代码实现对身份证正则校验
    public static boolean checkId(String id, int[] weight) {
        // 身份证正则表达式
        String regex = "^(\\d{14}|\\d{17})(\\d|[xX])$";
        if (!id.matches(regex))
            return false;
        int sum = 0;
        for (int i = 0; i < weight.length; i++) {
            int c = id.charAt(i) - '0';
            sum += weight[i] * c;
        }
        return sum % 11 == 0;

    }
    // 简单的写一个函数，返回一个随机数
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
    // 简单的写一个函数，返回一个随朷字符中文
    public static String randomChinese() {
        return randomChinese(random(1, 10));
    }
    // 简单的写一个函数，返回一个随朷字符中文
    public static String randomChinese(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(randomChineseChar());
        }
        return sb.toString();
    }

    private static char[] randomChineseChar() {
        int code = random(0xB0A1, 0xF7ED);
        return String.valueOf((char) code).toCharArray();
    }
    // 编写代码实现对敏感词进行脱敏处理
    public static String getSensitive(String str) {
        // 对str中文隐藏中间间四位用*代替
        String regex = "^(\\w{3})(\\w{4})(\\w{4})$";
        str = str.replaceAll(regex, "$1****$3");
        return str;
    }
    // 编写代码实现写入字符串到本地test2.txt文件中
    public static void writeFile(String str) {
        // 创建一个文件对象
        File file = new File("test2.txt");
        // 创建一个文件输出流
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            // 写入文件
            fos.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 编写代码实现读取本地test2.txt文件中的字符串
    public static String readFile() {
        // 创建一个文件对象
        File file = new File("test2.txt");
        // 创建一个文件输入流
        FileInputStream fis = null;
        String str = "";
        try {
            fis = new FileInputStream(file);
            // 读取文件
            byte[] b = new byte[1024];
            int len = fis.read(b);
            str = new String(b, 0, len);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }
    // 编写代码实现HTTP客户端远程调用百度远程服务器
    public static String httpClient(String  urlStr) throws IOException {
        // 创建一个URL对象
        URL url = null;
        // 创建一个URL连接
        HttpURLConnection urlConn = null;
        // 创建一个输入流
        InputStream is = null;
        try {
            // 设置URL
            url = new URL(urlStr);
            // 获取URL连接
            urlConn = (HttpURLConnection) url.openConnection();
            // 设置请求方式
            urlConn.setRequestMethod("GET");
            // 设置连接超时时间
            urlConn.setConnectTimeout(5000);
            // 设置读取超时时间
            urlConn.setReadTimeout(5000);
            // 设置请求头
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // 获取输入流
        is = urlConn.getInputStream();
        // 读取输入流
        byte[] b = new byte[1024];
        int len = -1;
        StringBuffer sb = new StringBuffer();
        try {
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
