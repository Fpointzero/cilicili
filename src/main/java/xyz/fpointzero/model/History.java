package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.HistoryMapper;
import xyz.fpointzero.util.MyBatisUtil;

import java.util.List;

public class History {
    private Integer uid;
    private Integer vid;
    public String time;

    //    Video video;
    private String videoPath;
    private String coverPath;
    private String title;
    private String starNumber;
    public String playNumber;
    public String videoTime;

    public static List<History> getHistoryList(User user) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            HistoryMapper HistoryMapper = sqlSession.getMapper(HistoryMapper.class);
            List<History> HistoryList = HistoryMapper.getHistoryList(user.getId());
            return HistoryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean setHistory(User user,Integer vid){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            HistoryMapper HistoryMapper = sqlSession.getMapper(HistoryMapper.class);
            HistoryMapper.setHistory(user.getId(), vid);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
                HistoryMapper HistoryMapper = sqlSession.getMapper(HistoryMapper.class);
                HistoryMapper.updateHistory(user.getId(), vid);
                sqlSession.commit();
                return true;
            } catch (Exception e1) {
                e1.printStackTrace();
                return false;
            }
        }
    }

    public static boolean delHistory(User user,Integer vid){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            HistoryMapper HistoryMapper = sqlSession.getMapper(HistoryMapper.class);
            HistoryMapper.delHistory(user.getId(), vid);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delAll(User user){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            HistoryMapper HistoryMapper = sqlSession.getMapper(HistoryMapper.class);
            HistoryMapper.delAll(user.getId());
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
