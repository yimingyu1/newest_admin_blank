package cn.mingyu.admin.service.user;


import cn.mingyu.admin.domain.model.UserModel;

import java.util.List;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
public interface IUserService {

    int insertUser(UserModel userModel);

    List<UserModel> selectAllUserModel();

    UserModel selectUserModelByName(String userName);
}
