package xyz.fpointzero.controller.user;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.JSONUtil;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        "/api/user/userInfo"
})
public class UserInfoServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        new Msg<User>(Msg.SUCCESS, user, "获取信息成功").send(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(Msg.ERROR, null, "修改失败，用户名或者邮箱已存在");
        JSONObject json = JSONUtil.getParamsJSON(req);

        String username = json.getString("username");
        //String phoneNumber = json.getString("phoneNumber");
//        String avatar = json.getString("avatar");
        User user = (User) req.getSession().getAttribute("user");

        User userChange = new User();
        userChange.setUsername(username);
        //userChange.setPhoneNumber(phoneNumber);
//        userChange.setAvatar(avatar);

        if (user != null && user.updateAll(userChange)) {
            req.getSession().setAttribute("user", user);
            msg.setAll(200, user,  "修改成功");
        }
        msg.send(resp);
    }
}
