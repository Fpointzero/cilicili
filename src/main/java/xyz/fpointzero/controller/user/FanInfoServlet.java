package xyz.fpointzero.controller.user;

import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.Fan;
import xyz.fpointzero.model.Star;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/fanInfo")
public class FanInfoServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<Fan>>(Msg.ERROR,  null, "请求粉丝列表失败");
        User user = (User) req.getSession().getAttribute("user");
        List<Fan> FanList= Fan.getFanList(user);
        resp.getWriter().println(msg.setAll(200, FanList, "请求粉丝列表成功").toJSONString());
    }
}
