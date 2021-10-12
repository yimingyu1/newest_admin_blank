package cn.mingyu.admin.provider.controller.admin.user;


import cn.mingyu.admin.biz.user.UserBiz;
import cn.mingyu.admin.common.ApiResponse;
import cn.mingyu.admin.domain.param.user.UserParam;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@RestController
@RequestMapping("/admin/user")
@Slf4j
public class UserController {

    @Resource
    private UserBiz userBiz;

    @PostMapping(path = "/addUser.json")
    public ApiResponse<Object> addUser(@RequestBody UserParam userParam){
        log.info("addUser params userparam = {}", userParam);
        if (StringUtils.isEmpty(userParam.getUserName())){
            return ApiResponse.buildFail("用户名不能为空");
        }
        if (StringUtils.isEmpty(userParam.getUserPwd())){
            return ApiResponse.buildFail("密码不能为空");
        }
        return userBiz.addUser(userParam.getUserName(), userParam.getUserPwd());
    }

    @GetMapping(path = "/getAllUser.json")
    public ApiResponse<Object> getAllUsers(){
        return userBiz.getAllUser();
    }

    @PostMapping(path = "/login.json")
    public ApiResponse<Object> login(@RequestBody UserParam userParam){
        log.info("login params userparams = {}", userParam);
        if (StringUtils.isEmpty(userParam.getUserName())){
            return ApiResponse.buildFail("用户名不能为空");
        }
        if (StringUtils.isEmpty(userParam.getUserPwd())){
            return ApiResponse.buildFail("密码不能为空");
        }
        return userBiz.getUserByName(userParam.getUserName(), userParam.getUserPwd());
    }
    @GetMapping(path = "/getWeather.json")
    public JSONObject getWeather(){
        String weather = "{\n" +
                "error: 0,\n" +
                "status: \"success\",\n" +
                "date: \"2013-07-17\",\n" +
                "results: \n" +
                "[{\n" +
                "currentCity: \"北京市\",\n" +
                "weather_data: \n" +
                "[{\n" +
                "date: \"周三(今天, 实时：24℃)\",\n" +
                "dayPictureUrl: \"http://api.map.baidu.com/images/weather/day/duoyun.png\",\n" +
                "nightPictureUrl: \"http://api.map.baidu.com/images/weather/night/duoyun.png\",\n" +
                "weather: \"多云\",\n" +
                "wind: \"微风\",\n" +
                "temperature: \"23℃~ 15℃\"\n" +
                "},\n" +
                "{\n" +
                "date: \"明天（周四）\",\n" +
                "dayPictureUrl: \"http://api.map.baidu.com/images/weather/day/leizhenyu.png\",\n" +
                "nightPictureUrl: \"http://api.map.baidu.com/images/weather/night/zhongyu.png\",\n" +
                "weather: \"雷阵雨转中雨\",\n" +
                "wind: \"微风\",\n" +
                "temperature: \"29～22℃\"\n" +
                "},\n" +
                "{\n" +
                "date: \"后天（周五）\",\n" +
                "dayPictureUrl: \"http://api.map.baidu.com/images/weather/day/yin.png\",\n" +
                "nightPictureUrl: \"http://api.map.baidu.com/images/weather/night/duoyun.png\",\n" +
                "weather: \"阴转多云\",\n" +
                "wind: \"微风\",\n" +
                "temperature: \"31～23℃\"\n" +
                "},\n" +
                "{\n" +
                "date: \"大后天（周六）\",\n" +
                "dayPictureUrl: \"http://api.map.baidu.com/images/weather/day/duoyun.png\",\n" +
                "nightPictureUrl: \"http://api.map.baidu.com/images/weather/night/duoyun.png\",\n" +
                "weather: \"多云\",\n" +
                "wind: \"微风\",\n" +
                "temperature: \"31～24℃\"\n" +
                "}]}]}";
        JSONObject jsonObject = JSONObject.parseObject(weather);
        return jsonObject;
    }
}
