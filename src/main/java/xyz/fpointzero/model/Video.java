package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.VideoMapper;
import xyz.fpointzero.util.MyBatisUtil;

import java.util.List;

public class Video {
    private Integer id;
    private String videoPath;
    private String coverPath;
    private String title;
    private String subtitle;
    private String starNumber;
    private String playNumber;
    public String videoTime;
    public Integer uid;
    public String createTime;

    // User表内容
    public String username;

    public static List<Video> getAllVideoList() {
        List<Video> result = null;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            result = sqlSession.getMapper(VideoMapper.class).getAllVideoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Video> getVideoListByUid(Integer uid) {
        List<Video> result = null;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            result = sqlSession.getMapper(VideoMapper.class).getVideoListByUid(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Video> search(){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            List<Video> videoList = null;
            videoList = mapper.getByTitle("%"+title+"%");
            if (videoList.size() != 0){
                return videoList;
            }

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void play(){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            Video video = new Video();
            video = mapper.getById(String.valueOf(id));
            setVideo(video);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean uploadVideo() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            mapper.insertVideo(this);
            sqlSession.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Video getVideo(Integer vid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            return mapper.getById(String.valueOf(vid));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setVideo(Video video) {
        this.id=video.id;
        this.videoPath = video.videoPath;
        this.coverPath = video.coverPath;
        this.title = video.title;
        this.subtitle = video.subtitle;
        this.starNumber = video.starNumber;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getLikeNumber() {
        return starNumber;
    }

    public void setLikeNumber(String likeNumber) {
        this.starNumber = likeNumber;
    }

    public String getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(String starNumber) {
        this.starNumber = starNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(String playNumber) {
        this.playNumber = playNumber;
    }
}
