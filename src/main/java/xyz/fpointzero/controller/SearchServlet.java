package xyz.fpointzero.controller;

import xyz.fpointzero.model.User;
import xyz.fpointzero.model.Video;
import xyz.fpointzero.util.EmailSender;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends MyHttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<User>(400, null, "搜索失败");
        String keyword = req.getParameter("keyword");

        Video video = new Video();
        video.setTitle(keyword);
        if(video.search()){
            msg.setAll(200, video, "搜索成功");
            resp.getWriter().println(msg.toJSONString());
        } else {
            resp.getWriter().println(msg.toJSONString());
        }
    }
}
