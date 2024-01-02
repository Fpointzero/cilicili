package xyz.fpointzero.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.fpointzero.model.Video;

public interface VideoMapper {
    Video getByTitle(@Param("keyword")String keyword);
}
