package xyz.fpointzero.controller.user;

import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/userInfo")
public class UserInfoServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        msg = new Msg<User>(200, user, "获取信息");
        resp.getWriter().println(msg.toJSONString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("ac");
    }
}
