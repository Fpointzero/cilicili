package xyz.fpointzero.controller;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.UserMapper;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.DataUtil;
import xyz.fpointzero.util.Msg;
import xyz.fpointzero.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/signin")
public class SignInServlet extends MyHttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(400, null, "注册失败");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        String info=user.signIn(code);
        resp.getWriter().println(msg.setAll(200, user, info).toJSONString());
    }
}
