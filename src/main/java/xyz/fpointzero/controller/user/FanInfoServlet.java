package xyz.fpointzero.controller.user;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.Fan;
import xyz.fpointzero.model.Star;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/fanInfo")
public class FanInfoServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<Fan>>(Msg.ERROR, null);
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            content.append(line);
        }
        JSONObject json = JSONObject.parseObject(content.toString());
        String action = json.getString("action");
        User user = (User) req.getSession().getAttribute("user");

        if (action.equals("fan")) {
            List<Fan> FanList= Fan.getFanList(user);
            resp.getWriter().println(msg.setAll(200, FanList, "请求粉丝列表成功").toJSONString());
        } else if(action.equals("follow")){
            List<Fan> FollowList= Fan.getFollowList(user);
            resp.getWriter().println(msg.setAll(200, FollowList, "请求关注列表成功").toJSONString());
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<Fan>>(Msg.ERROR, null);
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            content.append(line);
        }
        JSONObject json = JSONObject.parseObject(content.toString());
        String uid = json.getString("uid");
        String action = json.getString("action");
        User user = (User) req.getSession().getAttribute("user");

        if (action.equals("follow")) {
            if (Fan.follow(user, Integer.valueOf(uid))) {
                resp.getWriter().println(msg.setAll(200, null, "关注成功").toJSONString());
            } else {
                resp.getWriter().println(msg.toJSONString());
            }
        } else if (action.equals("unfollow")){
            if(Fan.unfollow(user, Integer.valueOf(uid))) {
                resp.getWriter().println(msg.setAll(200, null, "取关成功").toJSONString());
            } else{
                resp.getWriter().println(msg.toJSONString());
            }
        }
    }
}
