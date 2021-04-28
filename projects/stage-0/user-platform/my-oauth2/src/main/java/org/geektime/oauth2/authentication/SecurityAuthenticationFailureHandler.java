package org.geektime.oauth2.authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-04-28 3:42 下午
 * @Version 1.0
 **/
public class SecurityAuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if (request.getHeader("accept").contains("application/json")) {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            PrintWriter out = response.getWriter();
            // 输出失败的原因
            out.write("{\"error_code\":\"401\", \"name\":\"" + e.getClass() + "\", \"message\":\"" + e.getMessage() + "\"}");
        } else {
            super.onAuthenticationFailure(request, response, e);
        }
    }
}
