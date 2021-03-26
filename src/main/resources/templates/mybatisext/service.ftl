package ${package};

import com.github.pagehelper.PageInfo;
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
public interface ${simpleName} {

    /**
    * 新增${model.comment}
    *
    * @param id
    */
    ${model.simpleName} get${model.simpleName}ByPrimaryKey(${field.typeSimpleName} id);
    /**
    * 新增${model.comment}
    *
    * @param ${model.varName}
    */
    int add${model.simpleName}(${model.simpleName} ${model.varName});
    /**
    * 通过ID删除单个${model.comment}
    *
    * @param id ID
    */
    int delete${model.simpleName}ByPrimaryKey(${field.typeSimpleName} id);
    /**
    * 修改${model.comment}
    *
    * @param ${model.varName}
    */
    int update${model.simpleName}(${model.simpleName} ${model.varName});
    /**
    * 分页查询${model.comment}
    *
    * @param pageNum   页号
    * @param pageSize 每页大小
    * @return
    */
    PageInfo<${model.simpleName}> get${model.simpleName}PageList(Integer pageNum, Integer pageSize);
}
</#if>
</#list>