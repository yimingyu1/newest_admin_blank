package cn.mingyu.admin.dao.user.write;

import cn.mingyu.admin.domain.schema.UserDO;
import org.apache.ibatis.annotations.Insert;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
public interface IUserWriteDAO {

    @Insert("insert into user(user_name, user_pwd, deleted, create_time, update_time) values " +
            "(#{userName}, #{userPwd}, #{deleted}, #{createTime}, #{updateTime})")
    int insertUser(UserDO userDO);
}
