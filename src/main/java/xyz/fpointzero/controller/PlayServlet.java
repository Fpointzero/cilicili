package xyz.fpointzero.controller;

import xyz.fpointzero.mapper.HistoryMapper;
import xyz.fpointzero.model.History;
import xyz.fpointzero.model.Star;
import xyz.fpointzero.model.User;
import xyz.fpointzero.model.Video;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/play")
public class PlayServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<Video>(400, null, "视频获取失败");
        String vid = req.getParameter("vid");
        User user = (User) req.getSession().getAttribute("user");

        if(History.setHistory(user, Integer.valueOf(vid))) {
            Video video = new Video();
            video.setId(Integer.valueOf(vid));
            video.play();
            msg.setAll(200, video, "视频获取成功");
            resp.getWriter().println(msg.toJSONString());
        } else{
            msg = new Msg<Video>(400, null, "历史记录设置失败");
            resp.getWriter().println(msg.toJSONString());
        }
    }
}
