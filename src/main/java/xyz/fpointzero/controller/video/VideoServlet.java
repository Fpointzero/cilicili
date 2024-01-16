package xyz.fpointzero.controller.video;

import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/api/getVideoContent")
public class VideoServlet extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        JSONObject json = JSONUtil.getParamsJSON(req);
//        String filePath = null;
//        try {
//            ResultSet rs = FileUtil.getFilePath(fileId);
//            if (rs.next()) { // 确保结果集不为空
//                filePath = rs.getString("path");
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        Integer vid = Integer.valueOf(req.getParameter("vid"));
        Video video = Video.getVideo(vid);
        String filePath = video.getVideoPath();
        File downloadFile = new File(filePath);

        // 设置MIME类型和头信息
        String mimeType = getServletContext().getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        resp.setContentType(mimeType);
        resp.setContentLength((int) downloadFile.length());

        // 对文件名进行URL编码处理
        String encodedFileName = URLEncoder.encode(downloadFile.getName(), "UTF-8").replaceAll("\\+", "%20");
        String headerValue = "attachment; filename*=UTF-8''" + encodedFileName;
        resp.setHeader("Content-Disposition", headerValue);

        // 使用try-with-resources语句来自动关闭资源
        try (FileInputStream inStream = new FileInputStream(downloadFile);
             OutputStream outStream = resp.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            // 不需要手动关闭inStream和outStream，try-with-resources会自动关闭
            outStream.flush();
        }
    }
}
