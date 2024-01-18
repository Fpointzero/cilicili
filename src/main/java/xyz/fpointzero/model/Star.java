package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.Setting;
import xyz.fpointzero.mapper.StarMapper;
import xyz.fpointzero.mapper.VideoMapper;
import xyz.fpointzero.util.FileUtil;
import xyz.fpointzero.util.MyBatisUtil;

import java.util.List;

public class Star {
    public Integer uid;
    public Integer vid;
    public String group = "default";
    public String createTime;

    //    Video video;
    private String videoPath;
    private String coverPath;
    private String title;
    private Integer starNumber;
    public Integer playNumber;
    public String videoTime;

    public static synchronized boolean setStar(Star star) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            StarMapper starMapper = sqlSession.getMapper(StarMapper.class);
            if (star.group == null) {
                starMapper.insertStarDefault(star);
            }
            else
                starMapper.insertStar(star);

            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            Video video = mapper.getById(String.valueOf(star.vid));
            mapper.updateStarNumber(video.getId(), video.getStarNumber() + 1);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static synchronized boolean unsetStar(Star star) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            StarMapper starMapper = sqlSession.getMapper(StarMapper.class);
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            starMapper.delete(star);
            sqlSession.getMapper(VideoMapper.class);
            Video video = mapper.getById(String.valueOf(star.vid));
            mapper.updateStarNumber(video.getId(), video.getStarNumber() - 1);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static List<Star> getStarList(User user, String group) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            StarMapper starMapper = sqlSession.getMapper(StarMapper.class);
            List<Star> starList = starMapper.getStarList(user.getId(), group);
            for (Star star : starList) {
                star.setCoverPath(Setting.FILE_SERVER_COVER + FileUtil.urlSeparator + star.getCoverPath());
                star.setVideoPath(Setting.FILE_SERVER_VIDEO + FileUtil.urlSeparator + star.getVideoPath());
            }
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

    public void setStarNumber(Integer starNumber) {
        this.starNumber = starNumber;
    }

    public Integer getStarNumber() {
        return starNumber;
    }
}
