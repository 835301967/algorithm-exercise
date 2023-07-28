package easy;

/**
 *https://leetcode.cn/problems/longest-common-prefix/
 */
public class commonPrefix {
    public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
        return "";
    }
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        int j = 0;
        int min = Math.min(prefix.length(), strs[i].length());
        while (j < min && prefix.charAt(j) == strs[i].charAt(j)) {
            j++;
        }
        if (j == 0) {
            return "";
        }
        prefix = prefix.substring(0, j);
    }
    return prefix;
}
// 编写代码实现HTTP客户端
public static void main(){
    try {
    java.net.URL url = new java.net.URL("http://www.example.com");
    java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
    }
    in.close();
    conn.disconnect();
} catch(Exception e) {
    e.printStackTrace();
}
}



}
