package ${package};

import com.github.pagehelper.PageInfo;
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
public interface ${simpleName} {

    /**
    * 通过${field.name} 查询单个${model.comment}
    *
    * @param ${field.name} ${field.comment}
    * @return {@link ${dto.simpleName}}
    */
    ${dto.simpleName} getByPrimaryKey(${field.typeSimpleName} ${field.name});
    /**
    * 插入${model.comment}
    *
    * @param ${dto.varName} ${model.comment}
    * @return
    */
    int add(${dto.simpleName} ${dto.varName});


    /**
    * 通过${field.name} 删除单个${model.comment}
    *
    * @param ${field.name} ${field.comment}
    * @return
    */
    int deleteByPrimaryKey(${field.typeSimpleName} ${field.name});

    /**
    * 更新${dto.comment}
    *
    * @param ${dto.varName} ${model.comment}
    * @return
    */
    int update(${dto.simpleName} ${dto.varName});
}
</#if>
</#list>