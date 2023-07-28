package file;

import java.io.Serializable;
import lombok.Data;

/**
 * @Author yuxiangjin
 * @Date 2023/6/19 17:39
 **/
@Data
public class UserInfo implements Serializable {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户账号
     */
    private String ldapId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 单位ID
     */
    private String companyId;
    /**
     * 单位名称
     */
    private String companyName;
    /**
     * 用户归属部门
     */
}

