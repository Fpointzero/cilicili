package xyz.fpointzero.controller.user;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.History;
import xyz.fpointzero.model.User;
import xyz.fpointzero.model.Video;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/delHistory")
public class DelHistoryServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<History>>(Msg.ERROR,  null, "删除历史记录失败");
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            content.append(line);
        }
        JSONObject json = JSONObject.parseObject(content.toString());
        String vid = json.getString("vid");
        String action = json.getString("action");
        User user = (User) req.getSession().getAttribute("user");

        if (action.equals("one")) {
            if (History.delHistory(user, Integer.valueOf(vid))) {
                resp.getWriter().println(msg.setAll(200, null, "删除历史记录成功").toJSONString());
            } else {
                resp.getWriter().println(msg.toJSONString());
            }
        } else if (action.equals("all")) {
            if(History.delAll(user)) {
                resp.getWriter().println(msg.setAll(200, null, "删除历史记录成功").toJSONString());
            } else{
                resp.getWriter().println(msg.toJSONString());
            }
        }
    }
}
