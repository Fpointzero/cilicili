package xyz.fpointzero.controller;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/changePassword")
public class ChangePassword extends MyHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(Msg.ERROR, null);
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            content.append(line);
        }
        JSONObject json = JSONObject.parseObject(content.toString());

        User user = new User();
        user.setEmail(json.getString("email"));
        String code = json.getString("code");
        String password = json.getString("password");
        if (user.changePassword(code, password)) {
            msg.setAll(Msg.SUCCESS, null, "修改密码成功");
        }
        msg.send(resp);
    }
}
