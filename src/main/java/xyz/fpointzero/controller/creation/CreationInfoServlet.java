package xyz.fpointzero.controller.creation;

import com.alibaba.fastjson.JSONObject;
import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.User;
import xyz.fpointzero.model.Video;
import xyz.fpointzero.util.JSONUtil;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        "/api/creation/creationInfo"
})
public class CreationInfoServlet extends MyHttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        msg = new Msg<>(Msg.ERROR, null, "获取创作信息失败");
//
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        msg = new Msg<Video>(Msg.ERROR, null, "修改视频信息失败");
        JSONObject json = JSONUtil.getParamsJSON(req);
        User user = (User) req.getSession().getAttribute("user");
        String action = json.getString("action");
        if (action.equals("set")) {
            Integer vid = json.getInteger("vid");
            String title = json.getString("title");
            String subtitle = json.getString("subtitle");

            Video newVideo = new Video();
            newVideo.setId(vid);
            newVideo.setTitle(title);
            newVideo.setSubtitle(subtitle);

            Video video = Video.getVideo(vid);
            if (video != null && user.getId().equals(video.uid)) {
                video.updateAll(newVideo);
                msg.setAll(Msg.SUCCESS, video, "修改视频信息成功");
            }
        }
        msg.send(resp);
    }
}
