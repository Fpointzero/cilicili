package xyz.fpointzero.controller;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.UserMapper;
import xyz.fpointzero.model.User;
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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.getByEmail(email);
            String very = user.getVerification();
            String time = user.getVerificationTime();

            // 获取当前时间
            LocalDateTime currentTime = LocalDateTime.now();

            // 定义日期时间格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // 将时间字符串解析为 LocalDateTime 对象
            LocalDateTime sendTime = LocalDateTime.parse(time, formatter);
            // 计算两个 LocalDateTime 对象之间的时间差
            Duration duration = Duration.between(sendTime,currentTime);

            if(!very.equals("null")) {
                if (duration.toMinutes() < 5) {
                    if (code.equals(very)) {
                        mapper.setUsername(username, email);
                        mapper.setPassword(password, email);
                        mapper.setVery("null", time, email);
                        sqlSession.commit();
                        msg = new Msg<User>(200, user, "注册成功");
                        resp.getWriter().println(msg.toJSONString());
                    } else {
                        resp.getWriter().println("验证码错误");
                    }
                } else {
                    resp.getWriter().println("验证码失效");
                }
            } else{
                resp.getWriter().println("请先申请验证码");
            }




        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
