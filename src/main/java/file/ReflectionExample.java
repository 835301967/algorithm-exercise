package file;

/**
 * @Author yuxiangjin
 * @Date 2023/6/19 17:38
 **/
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            Class<?> userInfoClass = Class.forName("UserInfo");
            Object userInfoObject = userInfoClass.getDeclaredConstructor().newInstance();

            Method getUserInfoMethod = ReflectionExample.class.getDeclaredMethod("getUserInfo");
            Object userInfo = getUserInfoMethod.invoke(null);

            Method setCreateUserMethod = userInfoClass.getDeclaredMethod("setCreateUser", String.class);
            setCreateUserMethod.invoke(userInfoObject, getUserInfoPropertyValue(userInfo, "userName"));

            Method setUpdateUserMethod = userInfoClass.getDeclaredMethod("setUpdateUser", String.class);
            setUpdateUserMethod.invoke(userInfoObject, getUserInfoPropertyValue(userInfo, "userName"));

            Method setCreateUserIdMethod = userInfoClass.getDeclaredMethod("setCreateUserId", String.class);
            setCreateUserIdMethod.invoke(userInfoObject, getUserInfoPropertyValue(userInfo, "userId"));

            Method setUpdateUserIdMethod = userInfoClass.getDeclaredMethod("setUpdateUserId", String.class);
            setUpdateUserIdMethod.invoke(userInfoObject, getUserInfoPropertyValue(userInfo, "userId"));

            System.out.println(userInfoObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getUserInfo() {
        // Simulated method implementation
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("John Doe");
        userInfo.setUserId("12345");
        return userInfo;
    }

    public static String getUserInfoPropertyValue(Object userInfo, String propertyName) {
        try {
            Method getterMethod = userInfo.getClass().getDeclaredMethod("get" + capitalize(propertyName));
            return (String) getterMethod.invoke(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}

