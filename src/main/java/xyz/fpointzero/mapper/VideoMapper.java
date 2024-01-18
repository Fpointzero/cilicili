package xyz.fpointzero.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.fpointzero.model.Star;
import xyz.fpointzero.model.Video;

import java.util.List;

public interface VideoMapper {
    List<Video> getByTitle(@Param("keyword") String keyword);
    Video getById(@Param("id") String id);
    List<Video> getAllVideoList();
    Video getLatestVideoByUid(Integer uid);
    List<Video> getVideoListByUid(@Param("uid") Integer uid);
    int updatePlayerNumber(Video video);
    int updateStarNumber(@Param("vid") Integer vid, @Param("starNumber") Integer starNumber);
    void insertVideo(Video video);
    void updateAll(Video video);
    void updateCover(Video video);

}
