package easy;

import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;

/**
 *https://leetcode.cn/problems/longest-common-prefix/
 */
public class commonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String str = strs[0];
        HashMap<Integer, Character> strMap = new HashMap<Integer, Character>();
        if (str.length()==0){
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            strMap.put(i,c);
        }
        int min = str.length();

        for (int i = 1; i < strs.length; i++) {
            String tempStr = strs[i];
            if (tempStr.length()<=min){
                min = tempStr.length();
            }
            for (int j = 0; j < tempStr.length(); j++) {
                if ((strMap.get(j)==null)){
                    break;
                }
                if ((strMap.get(j) != tempStr.charAt(j))&&j>=0&&j<=min){
                    min = j;
                    break;
                }
            }
        }
        if (min==0){
            return "";
        }
        String substring = str.substring(0, min);
        return substring;
    }
}
