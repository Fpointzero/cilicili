package xyz.fpointzero.controller;

import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePassword extends MyHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(Msg.ERROR, null);
        User user = new User();
        user.setEmail(req.getParameter("email"));
        String code = req.getParameter("code");
        String password = req.getParameter("password");
        if (user.changePassword(code, password)) {
            msg.setAll(Msg.SUCCESS, null, "修改密码成功");
        }
        msg.send(resp);
    }
}
