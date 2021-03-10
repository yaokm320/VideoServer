package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.User;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author lkmc2
 * @date 2018/9/30
 * @description 注册登陆控制器测试
 */
public class RegisterLoginControllerTest extends BaseControllerTest {

    @Test
    public void register() throws Exception {
        User user = new User();
        user.setUsername("Java");
        user.setPassword("123456");

        String requestJson = JSONObject.toJSONString(user);

        String responseString = mockMvc.perform
                (
                        MockMvcRequestBuilders
                                .post("http://127.0.0.1/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.username").value("Java"))
                .andExpect(jsonPath("$.data.password").value(""))
                .andDo(print())
//                .andExpect(status().isBadRequest()) 400请求
                .andReturn().getResponse().getContentAsString();

        System.out.println("返回的结果：" + responseString);
    }

    @Test
    public void login() throws Exception {
        User user = new User();
        user.setUsername("Java");
        user.setPassword("123456");

        String requestJson = JSONObject.toJSONString(user);

        String responseString = mockMvc.perform
                (
                        MockMvcRequestBuilders
                        .post("http://127.0.0.1/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.username").value("Java"))
                .andExpect(jsonPath("$.data.password").value(""))
                .andExpect(jsonPath("$.data.userToken", notNullValue()))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(responseString);
    }

    @Test
    public void logout() throws Exception {
        // 此id从login的返回结果中获取
        String userId = "180930K3D6W4B44H";

        String responseString = mockMvc.perform
                (
                        MockMvcRequestBuilders
                                .post("http://127.0.0.1/logout?userId=" + userId)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(responseString);
    }

}