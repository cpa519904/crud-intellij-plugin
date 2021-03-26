package ${package+'.impl'};

import javax.annotation.Resource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
<#list imports as import>
    import ${import};
</#list>
/**
 * <dl>
 *    <dt><b>Title:</b></dt>
 *    <dd>
 *    	${comment}
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
    private ${mapper.simpleName} ${mapper.varName};
    /**
    * 通过${field.name} 查询单个${model.comment}
    *
    * @param ${field.name} ${field.comment}
    * @return {@link ${dto.simpleName}}
    */
    @Override
    public ${dto.simpleName} getByPrimaryKey(${field.typeSimpleName} ${field.name}){
        ${model.simpleName} ${model.varName} = ${mapper.varName}.selectByPrimaryKey(${field.name});
        ${dto.simpleName} ${dto.varName} =new ${dto.simpleName}();
        BeanUtils.copyProperties(${model.varName},${dto.varName});
        return ${dto.varName};
    }
    /**
    * 插入${model.comment}
    *
    * @param ${dto.varName} ${model.comment}
    * @return
    */
    @Override
    public int add(${dto.simpleName} ${dto.varName}){
        ${model.simpleName} ${model.varName} =new ${model.simpleName}();
        BeanUtils.copyProperties(${dto.varName},${model.varName});
        return ${mapper.varName}.insertSelective(${model.varName});
    }
    /**
    *通过${field.name} 删除单个${model.comment}
    *
    * @param ${field.name} ${field.comment}
    * @return
    */
    @Override
    public int deleteByPrimaryKey(${field.typeSimpleName} ${field.name}){
        return ${mapper.varName}.deleteByPrimaryKey(${field.name});
    }
    /**
    * 更新${model.comment}
    *
    * @param ${dto.varName} ${model.comment}
    * @return
    */
    @Override
    public int update(${dto.simpleName} ${dto.varName}){
        ${model.simpleName} ${model.varName} =new ${model.simpleName}();
        BeanUtils.copyProperties(${dto.varName},${model.varName});
        return ${mapper.varName}.updateByPrimaryKeySelective(${model.varName});
    }
}
</#if>
</#list>