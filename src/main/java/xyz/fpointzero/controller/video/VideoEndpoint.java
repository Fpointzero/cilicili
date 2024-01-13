package xyz.fpointzero.controller.video;

import xyz.fpointzero.model.Video;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

@ServerEndpoint("/video/{vid}")
public class VideoEndpoint {
    Video video;
    // 处理连接
    @OnOpen
    public void handleOpen(Session session, @PathParam("vid") Integer vid) throws IOException {
//        System.out.println(vid);
        video = Video.getVideo(vid);
//        session.getBasicRemote().sendText("connect");
    }

    // 处理消息
    @OnMessage
    public void handleMessage(String message, Session session) throws IOException {
        if (message.equals("get")) {
//            session.getBasicRemote().sendText("test");
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 10);
            try {
                FileChannel channel = FileChannel.open(Paths.get(video.getVideoPath()));

                while(channel.read(buffer) != -1) {
                    buffer.flip();
                    session.getBasicRemote().sendBinary(buffer);
                    buffer.clear();
                }

                channel.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭连接
    @OnClose
    public void handleClose(Session session) {
        // 从在线用户列表移除
    }

}