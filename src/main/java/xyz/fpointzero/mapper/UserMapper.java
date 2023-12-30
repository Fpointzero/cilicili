package xyz.fpointzero.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.fpointzero.model.User;

public interface UserMapper {
    User getById(int id);
    User getByEmail(String email);
    void setEmail(@Param("email")String email);
    void setVery(@Param("very")String very, @Param("time")String time, @Param("email")String email);
    User getByUsername(String username);
}
