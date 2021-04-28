package org.geektime.oauth2.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-04-28 3:43 下午
 * @Version 1.0
 **/
public class SecurityAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        if (request.getHeader("accept").contains("application/json")) {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("{\"error_code\":\"0\", \"message\":\"欢迎登录系统\"}");
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
