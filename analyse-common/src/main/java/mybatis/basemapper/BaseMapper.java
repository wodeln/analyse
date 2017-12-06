package mybatis.basemapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    int insert(T t)throws SQLException;
    int update(T t)throws SQLException;
    int getCountByMap(Map<String,Object> map)throws SQLException;
    int getCount()throws SQLException;
    T getById(long id)throws SQLException;
    T getByMap(Map<String,Object> map)throws SQLException;
    List<T> getAll()throws SQLException;
    List<T> getListByMap(Map<String,Object> map)throws SQLException;
//    List<T> getListBy
}
