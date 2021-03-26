package ${package};

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import java.util.List;
<#list imports as import>
    import ${import};
</#list>
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
@Repository
public class ${simpleName} extends SuperDal<${mapper.simpleName},${model.simpleName}> {
<#list model.fields as field>
    <#if field.id>
        @Override
        public int insertSelective(${model.simpleName} ${model.varName}) {
            return mapper.insertSelective(${model.varName});
        }
        @Override
        public int deleteByPrimaryKey(Object id){
            return super.deleteByPrimaryKey(id);
        }
        @Override
        public ${model.simpleName} selectByPrimaryKey(Object id) {
            return mapper.selectByPrimaryKey(id);
        }
        @Override
        public int selectCount(${model.simpleName} ${model.varName}) {
            return mapper.selectCount(${model.varName});
        }
        @Override
        public int updateByPrimaryKeySelective(${model.simpleName} ${model.varName}){
            return super.updateByPrimaryKeySelective(${model.varName});
        }
        @Override
        public List<${model.simpleName}> select(${model.simpleName} ${model.varName}) {
            return mapper.select(${model.varName});
        }
        public PageInfo<${model.simpleName}> selectPageList(Integer pageNo, Integer pageSize){
        ${model.simpleName} record=new ${model.simpleName}();
        PageHelper.startPage(pageNo,pageSize);
            PageInfo<${model.simpleName}> pageInfo = new PageInfo<>(super.select(record));
        return pageInfo;
        }
    </#if>
</#list>
}