package xyz.fpointzero.controller.video;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.Setting;
import xyz.fpointzero.controller.MyHttpServlet;
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
import java.util.List;

import static xyz.fpointzero.Setting.FILE_SERVER_COVER;
import static xyz.fpointzero.Setting.FILE_SERVER_VIDEO;

@WebServlet(urlPatterns = {
        "/api/video/getVideo",
        "/api/video/getVideos",
        "/api/video/getUserVideo"
})
public class GetVideoServlet extends MyHttpServlet {
    private static final String FILE_SERVER = Setting.FILE_SERVER;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<Video>>(400, null, "视频获取失败");
        String reqPath = req.getRequestURI().replace(req.getContextPath(), "");
        if (reqPath.equals("/api/video/getVideos")) {
            List<Video> videoList = Video.getAllVideoList();
            if (videoList != null)
                msg.setAll(Msg.SUCCESS, videoList, "全部视频获取成功");
        } else if (reqPath.equals("/api/video/getVideo")) {
            // 用于视频播放器播放获取视频
            JSONObject json = JSONUtil.getParamsJSON(req);
            Integer vid = Integer.valueOf(json.getString("vid"));
            User user = (User) req.getSession().getAttribute("user");
            try {
                Video video = Video.getVideo(vid);
                msg.setAll(Msg.SUCCESS, video, "视频获取成功");
                if (user != null)
                    History.setHistory(user, vid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (reqPath.equals("/api/video/getUserVideo")) {
            JSONObject json = JSONUtil.getParamsJSON(req);
            Integer uid = Integer.valueOf(json.getString("uid"));
            List<Video> videoList = Video.getVideoListByUid(uid);
            if (videoList != null)
                msg.setAll(Msg.SUCCESS, videoList, "获取用户视频成功");
        }
        msg.send(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<List<Video>>(400, null, "视频获取失败");
        String reqPath = req.getRequestURI().replace(req.getContextPath(), "");
        if (reqPath.equals("/api/video/getVideos")) {
            List<Video> videoList = Video.getAllVideoList();
            if (videoList != null)
                msg.setAll(Msg.SUCCESS, videoList, "全部视频获取成功");
        } else if (reqPath.equals("/api/video/getVideo")) {
            // 用于视频播放器播放获取视频
            JSONObject json = JSONUtil.getParamsJSON(req);
            Integer vid = Integer.valueOf(json.getString("vid"));
            User user = (User) req.getSession().getAttribute("user");
            try {
                Video video = Video.getVideo(vid);
                msg.setAll(Msg.SUCCESS, video, "视频获取成功");
                if (user != null)
                    History.setHistory(user, vid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (reqPath.equals("/api/video/getUserVideo")) {
            JSONObject json = JSONUtil.getParamsJSON(req);
            Integer uid = Integer.valueOf(json.getString("uid"));
            List<Video> videoList = Video.getVideoListByUid(uid);
            if (videoList != null)
                msg.setAll(Msg.SUCCESS, videoList, "获取用户视频成功");
        }
        msg.send(resp);
    }
}
