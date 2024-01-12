package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.FanMapper;
import xyz.fpointzero.mapper.HistoryMapper;
import xyz.fpointzero.mapper.StarMapper;
import xyz.fpointzero.util.MyBatisUtil;

import java.util.List;

public class Fan {
    public Integer uid;
    public Integer fanId;

    public static boolean follow(User user,Integer uid){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            FanMapper FanMapper = sqlSession.getMapper(FanMapper.class);
            FanMapper.follow(user.getId(), uid);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean unfollow(User user,Integer uid){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            FanMapper FanMapper = sqlSession.getMapper(FanMapper.class);
            FanMapper.unfollow(user.getId(), uid);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Fan> getFanList(User user) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            FanMapper FanMapper = sqlSession.getMapper(FanMapper.class);
            List<Fan> FanList = FanMapper.getFanList(user.getId());
            return FanList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Fan> getFollowList(User user) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            FanMapper FanMapper = sqlSession.getMapper(FanMapper.class);
            List<Fan> FollowList = FanMapper.getFollowList(user.getId());
            return FollowList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
