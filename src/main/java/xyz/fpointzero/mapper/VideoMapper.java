package xyz.fpointzero.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.fpointzero.model.Video;

import java.util.List;

public interface VideoMapper {
    List<Video> getByTitle(@Param("keyword")String keyword);
}
