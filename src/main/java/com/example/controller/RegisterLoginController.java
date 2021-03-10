package com.example.controller;

import com.example.entity.User;
import com.example.entity.vo.UserVo;
import com.example.utils.JsonResult;
import com.example.utils.MD5Utils;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@Api(value = "用户注册登陆的接口", tags = {"注册登陆的Controller"})
@RestController
public class RegisterLoginController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册的接口")
    @PostMapping("/register")
    public JsonResult register(@RequestBody User user) throws Exception {

        // 1.判断用户名和密码必须不能为空
        if (StringUtils.isBlank(user.getUsername())
                || StringUtils.isBlank(user.getPassword())) {
            return JsonResult.errorMsg("用户名和密码不能为空");
        }

        // 2.判断用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(user.getUsername());

        // 3.保存用户，注册信息
        if (!isExist) {
            user.setUsername(user.getUsername());
            user.setNickname(user.getNickname());
            // 密码进行MD5加密
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0);
            user.setReceiveLikeCounts(0);
            user.setFollowCounts(0);

            // 保存用户到数据库
            userService.saveUser(user);
        } else {
            return JsonResult.errorMsg("用户名已存在，请更换一个再尝试");
        }

        // 清空密码
        user.setPassword("");

        // 设置用户Token到Redis中
            UserVo userVo = setUserRedisSessionToken(user);

        // 返回Vo对象
        return JsonResult.ok(userVo);
    }

    @ApiOperation(value = "用户登陆", notes = "用户登陆的接口")
    @PostMapping("/login")
    public JsonResult login(@RequestBody User user) throws Exception {

        // 1.判断用户名和密码必须不能为空
        if (StringUtils.isBlank(user.getUsername())
                || StringUtils.isBlank(user.getPassword())) {
            return JsonResult.errorMsg("用户名和密码不能为空");
        }

        // 2.判断用户名和密码是否存在（密码进行MD5加密）
        User resultUser = userService.queryUserForLogin(user.getUsername(),
                                                        MD5Utils.getMD5Str(user.getPassword()));

        // 3.登陆失败
        if (resultUser == null) {
            return JsonResult.errorMsg("用户名或密码错误");
        }

        // 清空密码，返回用户信息
        resultUser.setPassword("");

        // 设置用户Token到Redis中
        UserVo userVo = setUserRedisSessionToken(resultUser);

        // 返回用户视图对象
        return JsonResult.ok(userVo);
    }

    @ApiOperation(value = "用户注销", notes = "用户注销的接口")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
    @PostMapping("/logout")
    public JsonResult logout(String userId) {
        redis.del(USER_REDIS_SESSION + ":" + userId);
        return JsonResult.ok();
    }

    /**
     * 设置用户Token到Redis中
     * @param user 用户
     * @return 用户视图对象
     */
    private UserVo setUserRedisSessionToken(User user) {
        // 生成Token
        String uniqueToken = UUID.randomUUID().toString();

        // 将用户信息存入Redis（有效期30分钟）
        redis.set(USER_REDIS_SESSION + ":" + user.getId(), uniqueToken, 1000 * 60 * 30);

        // 用户视图对象
        UserVo userVo = new UserVo();

        // 将用户中的属性拷贝到Vo对象
        BeanUtils.copyProperties(user, userVo);

        // 设置Token到Vo对象
        userVo.setUserToken(uniqueToken);

        return userVo;
    }
}
