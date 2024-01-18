package xyz.fpointzero.controller;

import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/api/logout")
public class LogoutServlet extends MyHttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(Msg.ERROR, null, "退出登录失败");
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        session.invalidate();
        msg.setAll(Msg.SUCCESS, null, "退出登录成功");
        msg.send(resp);
    }
}
