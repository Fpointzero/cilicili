package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.StarMapper;
import xyz.fpointzero.util.MyBatisUtil;

import java.util.List;

public class Star {
    private Integer uid;
    private Integer vid;
    public String createDate;

//    Video video;
    private String videoPath;
    private String coverPath;
    private String title;
    private String starNumber;
    public String playNumber;
    public String videoTime;

    public static List<Star> getStarList(User user) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            StarMapper starMapper = sqlSession.getMapper(StarMapper.class);
            List<Star> starList = starMapper.getStarList(user.getId());
            return starList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

//    public Video getVideo() {
//        return video;
//    }
//
//    public void setVideo(Video video) {
//        this.video = video;
//    }

    public String getCoverPath() {
        return coverPath;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public void setStarNumber(String starNumber) {
        this.starNumber = starNumber;
    }

    public String getStarNumber() {
        return starNumber;
    }
}
