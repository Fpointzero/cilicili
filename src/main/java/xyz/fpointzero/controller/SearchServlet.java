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
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends MyHttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<Video>>(400, null, "搜索失败");
        String keyword = req.getParameter("keyword");

        Video video = new Video();
        video.setTitle(keyword);
        List<Video> videoList = null;
        videoList = video.search();
        if(videoList != null){
            msg.setAll(200, videoList, "搜索成功");
            resp.getWriter().println(msg.toJSONString());
        } else {
            resp.getWriter().println(msg.toJSONString());
        }
    }
}
