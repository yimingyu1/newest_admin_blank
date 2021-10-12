package cn.mingyu.admin.dao.user.read;

import cn.mingyu.admin.domain.schema.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
public interface IUserReadDAO {
    @Select("select * from user where deleted = 0")
    @Results(id = "userMap", value = {
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "user_name", property = "userName"),
        @Result(column = "user_pwd", property = "userPwd"),
        @Result(column = "deleted", property = "deleted"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime"),
    })
    List<UserDO> selectAllUser();

    @Select("select * from user where user_name = #{userName} and deleted = 0")
    @ResultMap("userMap")
    UserDO selectUserByName(@Param("userName")String userName);
}
