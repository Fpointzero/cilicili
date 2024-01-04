package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.VideoMapper;
import xyz.fpointzero.util.MyBatisUtil;

public class Video {
    private Integer id;
    private String videoPath;
    private String coverPath;
    private String title;
    private String subtitle;
    private String starNumber;
    private String playNumber;
    public String videoTime;

    public boolean search(){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
            Video video = null;
            video = mapper.getByTitle("%"+title+"%");
            if (video == null){
                return false;
            } else {
                setVideo(video);
                return true;
            }

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void setVideo(Video video) {
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
