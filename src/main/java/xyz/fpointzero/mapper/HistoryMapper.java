package xyz.fpointzero.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.fpointzero.model.History;
import java.util.List;

public interface HistoryMapper {
    List<History> getHistoryList(Integer uid);
    void setHistory(@Param("uid")Integer uid, @Param("vid")Integer vid);
    void updateHistory(@Param("uid")Integer uid, @Param("vid")Integer vid);
    void delHistory(@Param("uid")Integer uid, @Param("vid")Integer vid);
    void delAll(@Param("uid")Integer uid);
}
