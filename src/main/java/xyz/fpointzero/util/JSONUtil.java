package xyz.fpointzero.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JSONUtil {
    public static JSONObject getParamsJSON(HttpServletRequest req) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            content.append(line);
        }
        return JSONObject.parseObject(content.toString());
    }
}
