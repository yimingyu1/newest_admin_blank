package cn.mingyu.admin.domain.schema;

import cn.mingyu.admin.domain.BaseObj;
import lombok.Data;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@Data
public class UserDO extends BaseObj {
    private static final long serialVersionUID = 7203494463270353657L;
    private String userName;
    private String userPwd;
    private Integer deleted;
}
