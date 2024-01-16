package xyz.fpointzero.controller;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/api/signin")
public class SignInServlet extends MyHttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(400, null, "注册失败");
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            content.append(line);
        }
        JSONObject json = JSONObject.parseObject(content.toString());
        String username = json.getString("username");
        String password = json.getString("password");
        String email = json.getString("email");
        String code = json.getString("code");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        String info=user.signIn(code);
        resp.getWriter().println(msg.setAll(200, user, info).toJSONString());
    }
}
