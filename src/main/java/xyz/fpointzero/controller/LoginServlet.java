package xyz.fpointzero.controller;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.JSONUtil;
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
        JSONObject json = JSONUtil.getParamsJSON(req);
        String type = json.getString("type");
        User user = null;
        if (type != null && type.equals("pwd")) {
            String username = json.getString("username");
            String password = json.getString("password");

            user = new User();
            if (username == null) {
                msg.send(resp);
                return;
            }
            user.setUsername(username);
            user.setPassword(password);
            if (user.login()) {
                msg.setAll(Msg.SUCCESS, user, "登录成功");
                req.getSession().setAttribute("user", user);
            }

        } else if (type != null && type.equals("code")) {
            String email = json.getString("email");
            String code = json.getString("code");
            user = User.loginByCode(email, code);
            if (user != null) {
                req.getSession().setAttribute("user", user);
                msg.setAll(Msg.SUCCESS, user, "登录成功");
            }
        }

        msg.send(resp);
    }

}
