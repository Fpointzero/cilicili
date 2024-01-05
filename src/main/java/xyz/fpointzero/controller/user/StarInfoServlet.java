package xyz.fpointzero.controller.user;

import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.Star;
import xyz.fpointzero.model.User;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {
        "/user/starInfo"
})
public class StarInfoServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<Star>>(Msg.ERROR, null, "请求收藏列表失败");
        User user = (User) req.getSession().getAttribute("user");
        String group = req.getParameter("group");

        List<Star> starList = Star.getStarList(user, group);

        msg.setAll(Msg.SUCCESS, starList, "请求收藏列表成功");
        msg.send(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<Star>(Msg.ERROR, null);
        User user = (User) req.getSession().getAttribute("user");
        Star star = new Star();
        star.vid = Integer.valueOf(req.getParameter("vid"));
        star.uid = user.getId();
        star.group = req.getParameter("group");
        String action = req.getParameter("action");
        if (action.equals("set")) {
            if (Star.setStar(star)) {
                msg.setAll(Msg.SUCCESS, star);
            }
        } else if (action.equals("unset")) {
            if (Star.unsetStar(star)) {

            }
        }

        msg.send(resp);
    }
}
