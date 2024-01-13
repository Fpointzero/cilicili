package xyz.fpointzero.controller.user;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        "/user/userInfo"
})
public class UserInfoServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        msg = new Msg<User>(200, user, "获取信息");
        resp.getWriter().println(msg.toJSONString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(400, null, "修改失败");
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            content.append(line);
        }
        JSONObject json = JSONObject.parseObject(content.toString());
        String username = json.getString("username");
        String phoneNumber = json.getString("phoneNumber");
        String avatar = json.getString("avatar");
        User user = (User) req.getSession().getAttribute("user");

        User userChange = new User();
        userChange.setUsername(username);
        userChange.setPhoneNumber(phoneNumber);
        userChange.setAvatar(avatar);

        if (user != null && user.updateAll(userChange)) {
            req.getSession().setAttribute("user", user);
            msg.setAll(200, user, "修改成功");
            resp.getWriter().println(msg.toJSONString());
        } else
            resp.getWriter().println(msg.toJSONString());
    }
}
