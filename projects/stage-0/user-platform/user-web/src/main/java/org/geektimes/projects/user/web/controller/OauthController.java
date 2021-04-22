package org.geektimes.projects.user.web.controller;

import org.geektimes.web.mvc.controller.Controller;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/auth")
public class OauthController implements Controller {

    @GET
    @POST
    @Path("/world") // /hello/world -> HelloWorldController
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "index.jsp";
    }

    @GET
    @POST
    @Path("/world1") // /hello/world -> HelloWorldController
    public String execute1(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "index.jsp";
    }
}
