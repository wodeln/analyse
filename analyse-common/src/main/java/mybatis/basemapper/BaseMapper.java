package mybatis.basemapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    /**
     * 获取所有对象列表
     * @return List<T> 对象列表
     */
    List<T> selectAll();

    /**
     * 根据传入对象属性获取相应对象列表
     * @param t 对象
     * @return List<T> 对象列表
     */
    List<T> select(T t);

    /**
     * 根据主键获取对象信息
     * @param id 主键ID
     * @return T 对象信息
     */
    T selectByPrimaryKey(long id);

    /**
     * 根据传入对象属性获取对象信息
     * @param t 对象
     * @return T 对象信息
     */
    T selectOne(T t);

    /**
     * 新增对象信息(所有字段信息)
     * @param t 对象信息
     * @return int
     */
    int insert(T t);

    /**
     * 新增对象信息(非空字段)
     * @param t 对象信息
     * @return int
     */
    int insertSelective(T t);

    /**
     * 批量新增对象信息
     * @param ts 对象List
     * @return int
     */
    int insertList(List<T> ts);

    /**
     * 根据主键更新对象信息(非空字段)
     * @param t
     * @return
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * 根据主键更新对象信息(所有字段)
     * @param t 对象
     * @return int
     */
    int updateByPrimaryKey(T t);

    /**
     * 根据传入对象属性获取相应数量
     * @param t 对象
     * @return int
     */
    int selectCount(T t);

    /**
     * 根据Object信息获取对象List
     * @param o Map/对象
     * @return
     */
    List<T> selectByInfo(Object o);

    /**
     * 批量删除
     * @param map
     * @return
     */
    int batchDel(Map<String,Object> map);
}
