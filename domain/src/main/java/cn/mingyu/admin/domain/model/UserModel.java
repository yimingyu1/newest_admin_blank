package cn.mingyu.admin.domain.model;

import cn.mingyu.admin.domain.BaseObj;
import lombok.Data;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@Data
public class UserModel extends BaseObj {
    private static final long serialVersionUID = -1757265489746726795L;
    private String userName;
    private String userPwd;
    private Integer deleted;
}
