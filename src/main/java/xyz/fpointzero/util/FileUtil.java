package xyz.fpointzero.util;

public class FileUtil {
    public static String urlSeparator = "/";
    public static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex);
        } else {
            return "";
        }
    }
}
