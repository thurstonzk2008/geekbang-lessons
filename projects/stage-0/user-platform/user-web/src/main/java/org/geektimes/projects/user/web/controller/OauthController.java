package org.geektimes.projects.user.web.controller;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
import org.geektimes.projects.user.web.utils.HttpURLClient;
import org.geektimes.projects.user.web.utils.URLParamsUtil;
import org.geektimes.web.mvc.controller.Controller;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/github")
public class OauthController implements Controller {

//    private final ConfigProviderResolver provider = ConfigProviderResolver.instance();
//    private final Config providerConfig = provider.getConfig();
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private static final String GET_TOKEN_API = "https://github.com/login/oauth/access_token";
    private static final String GET_USER_INFO_API = "https://api.github.com/user";
    private static final String CLIENT_ID_KEY = "client_id";
    private static final String CLIENT_SECRETS_KEY = "client_secrets";
    private static final String client_id = "18173c22846b013f30db";
    private static final String client_sercert = "af848d0ad32c189487da738de60645f11bfb1a79";


    @GET
    @Path("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
//        String client_id = providerConfig.getValue(CLIENT_ID_KEY, String.class);
        request.setAttribute("client_id", client_id);
        return "login-oauth.jsp";
    }

    @GET
    @Path("/oauth")
    public String oauth(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");

        // 获取 token
        Map<String, String> params = new HashMap<>();
        params.put("client_id", client_id);
        params.put("client_secret", client_sercert);
        params.put("code", code);
        String result = HttpURLClient.doPost(GET_TOKEN_API, URLParamsUtil.mapToStr(params));


        Map<String, String> resultMap =URLParamsUtil.resolveParamsByUrl("?" + result);
        String token = resultMap.get("access_token");
//
//        // 获取个人信息
        Map<String, String> headers = new HashMap<>();
        headers.put("", "" );
        String userInfo = HttpURLClient.doPostWithToken(GET_USER_INFO_API,URLParamsUtil.mapToStr(headers),token);

//        logger.info("user info is: " + userInfo);
//
//        JSONObject userObject = JSONObject.parseObject(userInfo);
//        String name = userObject.getString("name");
//        String avatar_url = userObject.getString("avatar_url");
//        request.setAttribute("avatar_url", avatar_url);
//        request.setAttribute("name", name)name;

        return "login-oauth-success.jsp";
    }
}
