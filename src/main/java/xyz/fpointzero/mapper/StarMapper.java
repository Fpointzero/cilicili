package xyz.fpointzero.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.fpointzero.model.Star;

import java.util.List;

public interface StarMapper {
    List<Star> getStarList(@Param("uid") Integer uid, @Param("group") String group);

    void insertStarDefault(Star star);

    void insertStar(Star star);

    void delete(Star star);
}
