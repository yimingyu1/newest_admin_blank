package cn.mingyu.admin.service.user.impl;

import cn.mingyu.admin.dao.user.read.IUserReadDAO;
import cn.mingyu.admin.dao.user.write.IUserWriteDAO;
import cn.mingyu.admin.domain.model.UserModel;
import cn.mingyu.admin.service.user.IUserService;
import cn.mingyu.admin.service.user.UserConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Resource
    private IUserWriteDAO userWriteDAO;

    @Resource
    private IUserReadDAO userReadDAO;

    @Override
    public int insertUser(UserModel userModel) {
        return userWriteDAO.insertUser(UserConverter.converter2UserDO(userModel));
    }

    @Override
    public UserModel selectUserModelByName(String userName) {
        return  UserConverter.converter2UserModel(userReadDAO.selectUserByName(userName));
    }

    @Override
    public List<UserModel> selectAllUserModel() {
        return UserConverter.converter2UserModelBatch(userReadDAO.selectAllUser());
    }
}
