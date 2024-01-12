package xyz.fpointzero.controller.user;

import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.Fan;
import xyz.fpointzero.model.History;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/unfollow")
public class UnfollowServlet extends MyHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<Fan>>(Msg.ERROR,  null, "取关失败");
        String uid = req.getParameter("uid");
        User user = (User) req.getSession().getAttribute("user");
        if(Fan.unfollow(user, Integer.valueOf(uid))) {
            resp.getWriter().println(msg.setAll(200, null, "取关成功").toJSONString());
        } else{
            resp.getWriter().println(msg.toJSONString());
        }
    }
}
