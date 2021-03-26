package ${superDalPackage};

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import ${baseMapperPackage}.BaseMapper;


/**
 * <dl>
 *    <dt><b>Title:</b></dt>
 *    <dd>
 *    	none
 *    </dd>
 *    <dt><b>Description:</b></dt>
 *    <dd>
 *    	<p>
 *    </dd>
 *
 * @author ${author}
 * @date ${datetime}
 */
public class SuperDal<M extends BaseMapper<T>, T>  {

    @Autowired
    protected M mapper;
    protected int delete(T t) {
    return mapper.delete(t);
    }
    protected int deleteByIds(String ids) {
    return mapper.deleteByIds(ids);
    }

    protected int deleteByExample(Object o) {
    return mapper.deleteByExample(o);
    }

    protected int deleteByPrimaryKey(Object o) {
    return mapper.deleteByPrimaryKey(o);
    }

    protected int insert(T t) {
    return mapper.insert(t);
    }

    @Options
    protected int insertList(List<? extends T> var1) {
    return mapper.insertList(var1);
    }

    protected int insertSelective(T t) {
    return mapper.insertSelective(t);
    }

    public List<T> select(T record) {
        return mapper.select(record);
    }
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    protected List<T> selectByIds(String var1) {

        return mapper.selectByIds(var1);
    }

    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int selectCount(T t) {
        return mapper.selectCount(t);
    }

    public List<T> selectByExample(Object o) {
        return mapper.selectByExample(o);
    }

    public int selectCountByExample(Object o) {
        return mapper.selectCountByExample(o);
    }

    public T selectOne(T t) {
    return mapper.selectOne(t);
    }

    protected int updateByExample(@Param("record") T t, @Param("example") Object o) {
    return mapper.updateByExample(t, o);
    }

    protected int updateByExampleSelective(@Param("record") T t, @Param("example") Object o) {
    return mapper.updateByExampleSelective(t, o);
    }

    protected int updateByPrimaryKey(T t) {
    return mapper.updateByPrimaryKey(t);
    }

    protected int updateByPrimaryKeySelective(T t) {
    return mapper.updateByPrimaryKeySelective(t);
    }

}