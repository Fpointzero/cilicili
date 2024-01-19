package xyz.fpointzero;

import xyz.fpointzero.util.FileUtil;

public class Setting {
    // 文件服务器
    public static final String FILE_SERVER = "http://localhost:8000";
    public static final String FILE_SERVER_VIDEO = FILE_SERVER + "/video";
    public static final String FILE_SERVER_COVER = FILE_SERVER + "/cover";
    public static final String UPLOAD_ROOT = "D:/cilicili_files";
    public static final String VIDEO_PATH = UPLOAD_ROOT + "/video";
    public static final String COVER_PATH = UPLOAD_ROOT + "/cover";
    public static final String AVATAR_PATH = UPLOAD_ROOT + "/avatar";

    // 邮件账号设置
    public static String senderEmail = "*******@qq.com";
    public static String senderPassword = "*******";

    // 邮件服务器配置
    public static String smtpHost = "smtp.qq.com";
    public static int smtpPort = 587;
}
