package aicodepair;

import java.util.Arrays;

import javax.annotation.RegEx;

/**
 * @Author yuxiangjin
 * @Date 2023/7/26 11:05
 **/
public class GithubCopilot {
    //写一个读取 csv 文件的函数
    public static String[] readCsv(String filename) {
        return readCsv(filename, ',');
    }
    // 编写一个算法，从文件 filename 读取 csv 格式的数据，并返回一个字符串数组。
    public static String[] readCsv(String filename, char delimiter) {
        return null;
    }

    // 编写一个函数，将一个字符串数组写入文件 filename 中。
    public static void writeCsv(String[] data, String filename) {
        writeCsv(data, filename, ',');
    }
    public static void writeCsv(String[] data, String filename, char delimiter) {

    }
    // 编写一个函数实现冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
    // 编写测试代码测试冒泡排序
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 5, 6, 7, 8, 9, 0};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
        // 编写代码实现对arr进行排序
        Arrays.stream(arr).forEach(System.out::print);
        if  (arr.length > 1) {
            System.out.println(arr.length);
        }

    }
    // 编写函数实现快速排序
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
    // 编写代码实现对邮箱正则校验
    public static boolean isEmail(String email) {
        // 邮箱正则表达式
        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return email.matches(regex);
    
    }
    // 编写代码实现对手机号正则校验
    public static boolean isPhone(String phone) {
        // 手朷正则表述
        String regex = "^1[0-9]{10}$";
        return phone.matches(regex);
    }
    // 编写代码实现对身份证正则校验
    public static boolean isIdCard(String idCard) {
        // 身份证正则表达式
        String regex = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        return idCard.matches(regex);
    }
    // 编写代码实现对敏感词进行脱敏处理
    public static String getSensitive(String str) {
        // 对str中文隐藏中间间四位用*代替
        String regex = "^(\\w{3})(\\w{4})(\\w{4})$";
        str = str.replaceAll(regex, "$1****$3");
        return str;
    }
    // 编写一段代码实现对用户名称校验字符

    public static boolean isUsername(String username) {
        // 用户名正则表述
        String regex = "^\\w{3,10}$";
        return username.matches(regex);
    }
    // 编写一段代码能够访问百度url并打印返回数据
    public static void accessBaidu() {
        try {
            java.net.URL url = new java.net.URL("http://www.baidu.com");
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    

}


