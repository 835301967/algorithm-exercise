package file;

/**
 * @Author yuxiangjin
 * @Date 2023/6/19 15:18
 **/
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLRegexExample {
    public static void main(String[] args) {
        String text = "https://www.example.com.png";
        String regex = "(https?://[\\w-]+(\\.[\\w-]+)*(?:(?:/[\\w-]*)+)?(?:/[\\w-]+\\.[\\w-]+)?)";

        boolean isUrl = isUrl(text);
        System.out.println(isUrl);
    }
    public static boolean isUrl(String urls) {
        if(StringUtils.isBlank(urls)) {
            return  true;
        }
        String regex = "(ht|f)tp(s?)\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\'\\/\\\\&%\\+\\$#_=]*)?";

        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(urls.trim());
        boolean result = mat.matches();
        return result;
    }
}

