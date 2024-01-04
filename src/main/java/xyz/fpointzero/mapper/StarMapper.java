package xyz.fpointzero.mapper;

import xyz.fpointzero.model.Star;

import java.util.List;

public interface StarMapper {
    List<Star> getStarList(Integer uid);
}
