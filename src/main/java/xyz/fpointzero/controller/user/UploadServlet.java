package xyz.fpointzero.controller.user;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import xyz.fpointzero.controller.MyHttpServlet;
import xyz.fpointzero.model.User;
import xyz.fpointzero.model.Video;
import xyz.fpointzero.util.FileUtil;
import xyz.fpointzero.util.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/upload")
public class UploadServlet extends MyHttpServlet {
    private static String UPLOAD_PATH = "/WEB-INF/upload";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getSession().getAttribute("user");
        msg = new Msg<Video>(Msg.ERROR, null);
// 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD);
        // 设置临时存储目录
        String tempContextPath = req.getServletContext().getRealPath("/WEB-INF/temp");
        File tempDirectory = new File(tempContextPath);
        if (!tempDirectory.exists()) {
            if (!tempDirectory.mkdir())
                return;
        }
        factory.setRepository(tempDirectory);

        upload.setSizeMax(1024L * 1024 * 1024); // 允许最大上传1G视频
        String userUploadPath = UPLOAD_PATH + "/" + user.getId();
        // 设置上传路径
        String uploadPath = req.getServletContext().getRealPath(userUploadPath);

        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理在表单中的字段
                    if (!item.isFormField()) {
                        Video video = new Video();
//                        String fileName = new File(item.getName()).getName();
                        String fileName = new File(item.getName()).getName();

                        long timestamp = System.currentTimeMillis();

                        File uploadDir = new File(uploadPath);
                        if (!uploadDir.exists()) {
                            if (!uploadDir.mkdirs())
                                return;
                        }
//                        String filePath = uploadPath + File.separator + timestamp + File.separator + fileName;
                        String newFileName = timestamp + FileUtil.getFileExtension(fileName); // 上传后文件内容
                        String filePath = uploadPath + File.separator + newFileName;
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);

                        File storeFile = new File(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);

                        video.setVideoPath(userUploadPath + FileUtil.urlSeparator + newFileName);
                        video.uid = user.getId();
                        video.uploadVideo();
//                        FileUtil.saveFileToDatabase(fileName, filePath);
                        msg = new Msg<Video>(Msg.SUCCESS, video);
                    }
                }
            }
        } catch (Exception ex) {
            req.setAttribute("message", "错误信息: " + ex.getMessage());
            throw new ServletException(ex);
        }

        msg.send(resp);
    }
}
