package xyz.fpointzero.controller;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.model.History;
import xyz.fpointzero.model.User;
import xyz.fpointzero.model.Video;
import xyz.fpointzero.util.FileUtil;
import xyz.fpointzero.util.JSONUtil;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getVideo")
public class GetVideoServlet extends MyHttpServlet {
    private static String FILE_SERVER = "http://localhost:8000";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<Video>(400, null, "视频获取失败");
        JSONObject json = JSONUtil.getParamsJSON(req);
        Integer vid = Integer.valueOf(json.getString("video_id"));
        User user = (User) req.getSession().getAttribute("user");
        try {
            Video video = Video.getVideo(vid);
            video.setVideoPath(FILE_SERVER + FileUtil.urlSeparator + video.getVideoPath());
            msg.setAll(Msg.SUCCESS, video, "视频获取成功");
            if (user != null)
                History.setHistory(user, vid);
        } catch (Exception e) {
            msg.setAll(400, null, "视频获取失败");
        }
        msg.send(resp);
    }
}
