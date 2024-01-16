package xyz.fpointzero.controller.user;

import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.History;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/user/historyInfo")
public class HistoryInfoServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<History>>(Msg.ERROR,  null, "请求历史记录失败");
        User user = (User) req.getSession().getAttribute("user");
        List<History> HistoryList= History.getHistoryList(user);
        resp.getWriter().println(msg.setAll(200, HistoryList, "请求历史记录成功").toJSONString());
    }
}
