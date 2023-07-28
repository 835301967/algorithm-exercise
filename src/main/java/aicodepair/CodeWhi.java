package aicodepair;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import junit.framework.Test;
import org.apache.ibatis.annotations.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

// ... 其他代码 ...

class CodeWhi {
    public static boolean isEmailValid(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    Pattern pat = Pattern.compile(emailRegex);
    if (email == null)
        return false;
    return pat.matcher(email).matches();
    }
    public static boolean isIDCardValid(String idCard) {
        String idCardRegex = "^[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}[0-9Xx]$";
        Pattern pat = Pattern.compile(idCardRegex);
        if (idCard == null)
            return false;
        return pat.matcher(idCard).matches();
    }
    public static boolean isPhoneValid(String phone){
        String phoneRegex = "^[0-9]{10}$";
        Pattern pat = Pattern.compile(phoneRegex);
        if (phone == null)
            return false;
        return pat.matcher(phone).matches();
    }


    


    public static void main(String[] args) {
        // 测试写入字符串到文件
        callRemoteServer();


    }

//     实现Mapper代码调用mysql数据库实现增删改查
    @Mapper
    public interface UserMapper {
        @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
        void addUser(@Param("name") String name, @Param("age") Integer age);

        @Delete("DELETE FROM user WHERE id =#{id}")
        void deleteUser(@Param("id") Integer id);

        @Update("UPDATE user SET name=#{name},age=#{age} WHERE id=#{id}")
        void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("id") Integer id);

    }
    // 编写函数实现生成随机汉字
    public static char getRandomHan() {
        String str = "";
        int highPos, lowPos; // 定义高低位
        Random random = new Random();
        highPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
        lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
        byte[] b = new byte[2];
        b[0] = (new Integer(highPos).byteValue());
        b[1] = (new Integer(lowPos).byteValue());
        try {
            str = new String(b, "GBk"); //转成中文
        } catch (java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return str.charAt(0);
    }
    // 编写函数实现生成随机姓名
    public static String getRandomName() {
        String str = "";
        int highPos, lowPos;
        Random random = new Random();
        highPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        byte[] b = new byte[2];
        b[0] = (new Integer(highPos).byteValue());
        b[1] = (new Integer(lowPos).byteValue());
        try {
            str = new String(b, "GBk");
        } catch (java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return str;
    }
    public static String getRandomName2() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            name.append(getRandomHan());
        }
        return name.toString();
    }
    // 随机生成中国的百家姓

    public static String getRandomName3() {
        // 百家姓

        String[] familyNames = {"豫", "鄂", "桂", "蒙", "畿", "晋", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙", "蒙"};
        return familyNames[new Random().nextInt(familyNames.length)];




    }
    public static String getRandomSurname() {
        String[] surnames = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹"};
        return surnames[new Random().nextInt(surnames.length)];
    }
    // 随机生成中国的百家姓
    public static String getRandomSurname2() {
        String[] surnames = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈"
                , "褚", "卫", "蒋", "殷", "韩", "怀", "谢", "邓", "涂", "郁", "蔡", "姚", "俊" +
                "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮" +
                "蓓", "闫", "席", "季", "高", "梅", "盛", "汤", "滕", "殷", "王", "毛", "麻", "苗" +
                "凤", "花", "方", "�", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑" +
                "薛", "雷", "蒋", "冷", "郎"};
        return surnames[new Random().nextInt(surnames.length)];
    }
    // 实现随机生成0-100的2位小数浮点数
    public static float getRandomFloat() {
        //
        float v = new Random().nextFloat() * 100;
        // 保留2位小数
        v = Math.round(v * 100) / 100f;
        return v;
    }
    // 实现随机生成0-100000的2位小数浮点数
    public static float getRandomFloat2() {
        float v = new Random().nextFloat() * 100000;
        // 保留2位小数
        v = Math.round(v * 100) / 100f;
        return v;
    }
    // 实现代码将一段字符串写入到本地test.txt文件
    public static void write(String str) {
        try {
            // 按照追加模式写入文件
            FileWriter fw = new FileWriter("test.txt", true);
            fw.write(str);
            fw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

/**
 * This function makes an HTTP GET request to the remote server hosted by Baidu.
 */
public static void callRemoteServer() {
    try {
        URL url = new URL("https://www.baidu.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response: " + response.toString());
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    // To make an HTTP request
    // 1. Create a URL object
    // 2. Create a connection
    // 3. Send a request
    // 4. Read the response
    // 5. Close the connection
    // 6. Print the response
    // 7. Handle exceptions
    // 8. Handle errors

}

    public static void callRemoteServer2() {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Keep-Alive", "timeout=5");
            conn.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Response: " + response.toString());
            conn.disconnect();
        } catch (ProtocolException | MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // 编写代码实现对手机号格式校验
    public static boolean checkPhone(String phone) {
        String phoneRegex = "^[0-9]{10}$";
        Pattern pat = Pattern.compile(phoneRegex);
        if (phone == null)
            return false;
        return pat.matcher(phone).matches();
    }
    // 编写代码实现对邮箱格式校验
    public static boolean checkEmail(String email) {
        String emailRegex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    // 编写代码实现对密码格式校验
    public static boolean checkPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}$";
        Pattern pat = Pattern.compile(passwordRegex);
        if (password == null)
            return false;
        return pat.matcher(password).matches();
    }


public static boolean checkIdCard(String idCard) {
    String idCardRegex = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
    Pattern pattern = Pattern.compile(idCardRegex);
    
    if (idCard == null) {
        System.out.println("Invalid input: idCard is null");
        return false;
    }
    
    Matcher matcher = pattern.matcher(idCard);
    boolean isMatch = matcher.matches();
    
    if (!isMatch) {
        System.out.println("Invalid input: idCard does not match the regex pattern");
    }
    
    return isMatch;
}
    }
