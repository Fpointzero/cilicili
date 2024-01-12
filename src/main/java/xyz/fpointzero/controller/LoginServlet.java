package xyz.fpointzero.controller;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends MyHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(400, null, "登录失败");
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            content.append(line);
        }
        JSONObject json = JSONObject.parseObject(content.toString());
        String username = json.getString("username");
        String password = json.getString("password");
        String email = "";

        if (username == null && email == null) {
            resp.getWriter().println(msg.toJSONString());
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        if (user.login()) {
            msg.setAll(200, user, "登录成功");
            resp.getWriter().println(msg.toJSONString());
        } else {
            resp.getWriter().println(msg.toJSONString());
        }

        req.getSession().setAttribute("user", user);
    }

}
