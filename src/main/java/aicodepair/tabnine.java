package aicodepair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author yuxiangjin
 * @Date 2023/7/26 17:30
 **/
public class tabnine {
    // 编写代码实现对敏感词进行脱敏处理
    public static void main(String[] args) {
        System.out.println(tabnine.class.getName());
    }
    // 编写代码实现对邮箱检验
    public static boolean isEmail(String email) {
        if (email == null || email.length() == 0) {
            return false;
        }
        String reg = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
    // 编写代码实现对手机号码检验
    public static boolean isPhone(String phone) {
        if (phone == null || phone.length() == 0) {
            return false;
        }
        String reg = "^1[34578]\\d{9}$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(phone);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
    // 编写代码实现对身份证号码检验
    public static boolean isIdCard(String idCard) {
        if (idCard == null || idCard.length() == 0) {
            return false;
        }
        String reg = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(idCard);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
    // 编写代码实现对邮政编码检验
    public static boolean isPostalCode(String postalCode) {
        if (postalCode == null || postalCode.length() == 0) {
            return false;
        }
        String reg = "^\\d{6}$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(postalCode);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
    // 编写代码实现对手机号进行脱敏
    public static boolean phonedel(String phonedel) {
        if (phonedel == null || phonedel.length() == 0) {
            return false;
        }
        String reg = "^1[34578]\\d{9}$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(phonedel);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
}
