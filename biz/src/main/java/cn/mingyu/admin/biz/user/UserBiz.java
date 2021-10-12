package cn.mingyu.admin.biz.user;

import cn.mingyu.admin.common.ApiResponse;
import cn.mingyu.admin.domain.model.UserModel;
import cn.mingyu.admin.service.user.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@Service
public class UserBiz {

    @Resource
    private IUserService userService;

    public ApiResponse<Object> addUser(String username, String userPwd){
        UserModel user = userService.selectUserModelByName(username);
        if (user != null){
            return ApiResponse.buildFail("用户名已存在");
        }
        UserModel userModel = new UserModel();
        userModel.setUserName(username);
        userModel.setUserPwd(userPwd);
        userModel.setDeleted(0);
        LocalDateTime now = LocalDateTime.now();
        userModel.setCreateTime(now);
        userModel.setUpdateTime(now);
        int rest = userService.insertUser(userModel);
        if (rest > 0){
            return ApiResponse.buildSuccess("创建用户成功");
        }
        return ApiResponse.buildFail("内部错误");
    }

    public ApiResponse<Object> getAllUser(){
        return ApiResponse.buildSuccess(userService.selectAllUserModel());
    }

    public ApiResponse<Object> getUserByName(String userName, String userPwd){
        UserModel userModel = userService.selectUserModelByName(userName);
        if (userModel == null){
            return ApiResponse.buildFail("用户名不存在");
        }
        if (!userModel.getUserPwd().equals(userPwd)){
            return ApiResponse.buildFail("密码错误，请确认后重试");
        }
        return ApiResponse.buildSuccess(userModel);
    }
}
