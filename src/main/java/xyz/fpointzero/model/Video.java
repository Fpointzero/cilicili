package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.VideoMapper;
import xyz.fpointzero.util.FileUtil;
import xyz.fpointzero.util.MyBatisUtil;

import java.util.List;

import static xyz.fpointzero.Setting.*;

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

    // =============================功能 start==============================
    public List<Video> search() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            List<Video> videoList = null;
            videoList = mapper.getByTitle("%" + title + "%");
            for (Video video : videoList) {
                video.setVideoPath(FILE_SERVER_VIDEO + FileUtil.urlSeparator + video.getVideoPath());
                video.setCoverPath(FILE_SERVER_COVER + FileUtil.urlSeparator + video.getCoverPath());
            }
            if (videoList.size() != 0) {
                return videoList;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void play() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            Video video = new Video();
            video = mapper.getById(String.valueOf(id));
            setVideo(video);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =============================功能 end==============================

    /**
     * 根据 ${vid} 获取视频
     * @param vid
     * @return
     */
    public static Video getVideo(Integer vid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            Video video = mapper.getById(String.valueOf(vid));
            video.setVideoPath(FILE_SERVER_VIDEO + FileUtil.urlSeparator + video.getVideoPath());
            video.setCoverPath(FILE_SERVER_COVER + FileUtil.urlSeparator + video.getCoverPath());
            return video;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据 ${uid} 获取最新的视频
     * @param uid
     * @return
     */
    public static Video getLatestVideoByUser(Integer uid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            return mapper.getLatestVideoByUid(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static Video getVideoByUser(Integer vid, Integer uid) {
//        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
//            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
//            return mapper.getById(String.valueOf(vid));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 获取全站视频
     * @return
     */
    public static List<Video> getAllVideoList() {
        List<Video> result = null;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            result = sqlSession.getMapper(VideoMapper.class).getAllVideoList();
            for (Video video : result) {
                video.setVideoPath(FILE_SERVER_VIDEO + FileUtil.urlSeparator + video.getVideoPath());
                video.setCoverPath(FILE_SERVER_COVER + FileUtil.urlSeparator + video.getCoverPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取 ${uid} 的所有视频
     * @param uid
     * @return
     */
    public static List<Video> getVideoListByUid(Integer uid) {
        List<Video> result = null;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            result = sqlSession.getMapper(VideoMapper.class).getVideoListByUid(uid);
            for (Video video : result) {
                video.setVideoPath(FILE_SERVER_VIDEO + FileUtil.urlSeparator + video.getVideoPath());
                video.setCoverPath(FILE_SERVER_COVER + FileUtil.urlSeparator + video.getCoverPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // update ----------------

    /**
     * 更新视频封面
     * @return
     */
    public boolean updateCover() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            mapper.updateCover(this);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 上传视频以后创建一个视频
     * @return
     */
    public boolean uploadVideo() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            mapper.insertVideo(this);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新视频的信息
     * @param video
     * @return
     */
    public boolean updateAll(Video video) {
        boolean result = false;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            this.setVideo(video);
            sqlSession.getMapper(VideoMapper.class).updateAll(this);
            sqlSession.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private void setVideo(Video video) {
        if (video.id != null)
            this.id = video.id;
        if (video.videoPath != null)
            this.videoPath = video.videoPath;
        if (video.coverPath != null)
            this.coverPath = video.coverPath;
        if (video.title != null)
            this.title = video.title;
        if (video.subtitle != null)
            this.subtitle = video.subtitle;
        if (video.starNumber != null)
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
