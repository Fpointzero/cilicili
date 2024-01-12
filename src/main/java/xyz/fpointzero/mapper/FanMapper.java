package xyz.fpointzero.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.fpointzero.model.Fan;
import xyz.fpointzero.model.Star;

import java.util.List;

public interface FanMapper {
    void follow(@Param("uid")Integer uid, @Param("fanId")Integer fanId);
    void unfollow(@Param("uid")Integer uid, @Param("fanId")Integer fanId);
    List<Fan> getFanList(Integer uid);
    List<Fan> getFollowList(Integer uid);
}
