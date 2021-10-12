package cn.mingyu.admin.service.user;

import cn.mingyu.admin.domain.model.UserModel;
import cn.mingyu.admin.domain.schema.UserDO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
public class UserConverter {

    public static UserDO converter2UserDO(UserModel userModel){
        UserDO userDO = new UserDO();
        userDO.setId(userModel.getId());
        userDO.setUserName(userModel.getUserName());
        userDO.setUserPwd(userModel.getUserPwd());
        userDO.setDeleted(userModel.getDeleted());
        userDO.setCreateTime(userModel.getCreateTime());
        userDO.setUpdateTime(userModel.getUpdateTime());
        return userDO;
    }

    public static UserModel converter2UserModel(UserDO userDO){
        UserModel userModel = null;
        if (userDO != null) {
            userModel = new UserModel();
            userModel.setId(userDO.getId());
            userModel.setUserName(userDO.getUserName());
            userModel.setUserPwd(userDO.getUserPwd());
            userModel.setDeleted(userDO.getDeleted());
            userModel.setCreateTime(userDO.getCreateTime());
            userModel.setUpdateTime(userDO.getUpdateTime());
        }
        return userModel;
    }

    public static List<UserModel> converter2UserModelBatch(List<UserDO> userDOS){
        System.out.println(userDOS);
        return userDOS.stream().map(UserConverter::converter2UserModel).collect(Collectors.toList());
    }
}
