package ${package+'.impl'};

import javax.annotation.Resource;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
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
<#list model.fields as field>
<#if field.id>
@Service
public class ${simpleName}Impl implements ${simpleName}{
    @Resource
    private ${dal.simpleName} ${dal.varName};
    /**
    * 通过ID查询单个${model.comment}
    *
    * @param id ID
    */
    @Override
    public ${model.simpleName} get${model.simpleName}ByPrimaryKey(${field.typeSimpleName} id){
        return ${dal.varName}.selectByPrimaryKey(id);
    }
    /**
    * 新增${model.comment}
    *
    * @param ${model.varName}
    */
    @Override
    public int add${model.simpleName}(${model.simpleName} ${model.varName}){
        return ${dal.varName}.insertSelective(${model.varName});
    }
    /**
    * 通过ID删除单个${model.comment}
    *
    * @param id ID
    */
    @Override
    public int delete${model.simpleName}ByPrimaryKey(${field.typeSimpleName} id){
        return ${dal.varName}.deleteByPrimaryKey(id);
    }
    /**
    * 修改${model.comment}
    *
    * @param ${model.varName} ${model.comment}
    */
    @Override
    public int update${model.simpleName}(${model.simpleName} ${model.varName}){
        return ${dal.varName}.updateByPrimaryKeySelective(${model.varName});
    }
    /**
    * 分页查询${model.comment}
    *
    * @param pageNum   页号
    * @param pageSize 每页大小
    */
    @Override
    public PageInfo<${model.simpleName}> get${model.simpleName}PageList(Integer pageNum, Integer pageSize){
        return ${dal.varName}.selectPageList(pageNum,pageSize);
    }
}
</#if>
</#list>