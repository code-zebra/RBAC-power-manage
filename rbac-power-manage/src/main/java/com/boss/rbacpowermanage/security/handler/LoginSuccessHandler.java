package com.boss.rbacpowermanage.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.boss.rbacpowermanage.entity.domain.UserDO;
import com.boss.rbacpowermanage.entity.po.UserPO;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 黄杰峰
 * @Date 2020/7/28 0028 16:56
 * @Description 授权成功处理器
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        //登录成功返回
        Map<String, Object> paramMap = new HashMap<>(8);
        paramMap.put("code", "400");
        paramMap.put("message", "登录成功!");

        UserDO userDO = (UserDO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPO user = new UserPO();
        BeanUtils.copyProperties(userDO, user);

        paramMap.put("user", user);
        //设置返回请求头
        response.setContentType("application/json;charset=utf-8");
        //写出流
        PrintWriter out = response.getWriter();
        out.write(JSONObject.toJSONString(paramMap));
        out.flush();
        out.close();
//        new DefaultRedirectStrategy().sendRedirect(request, response, "/index");
    }
}
