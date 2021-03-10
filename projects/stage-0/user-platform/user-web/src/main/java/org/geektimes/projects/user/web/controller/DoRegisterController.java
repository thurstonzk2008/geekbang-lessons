package org.geektimes.projects.user.web.controller;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 注册 Controller
 */
@Path("/doregister")
public class DoRegisterController implements PageController {

  //  @Resource(name="bean/UserService")
    private UserService userService;


    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String userEmail = request.getParameter("inputEmail");
        String userPassword = request.getParameter("inputPassword") ;
        String userName = request.getParameter("inputName") ;
        String userPhoneNumber = request.getParameter("inputPhoneNumber") ;
        //依赖查找,目前未实现注入
        ComponentContext componentContext = ComponentContext.getInstance();
        userService = componentContext.getComponent("bean/UserService");
        userService.register(new User(userName,userPassword,userEmail,userPhoneNumber));
        return "succ.jsp";
    }
}
