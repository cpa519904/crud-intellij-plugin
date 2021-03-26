package ${package};

import org.apache.ibatis.jdbc.SQL;
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
public class ${simpleName} {

    /**
    * 通过${field.name} 查询单个${model.comment}
    *
    * @param ${field.name} ${field.comment}
    * @return {@link ${dto.simpleName}}
    */
    public String insertSelective(${model.simpleName} ${model.varName}){
        return new SQL() {
            {
                UPDATE("${model.tableName}");
                <#list model.fields as fieldBase>
                <#if!fieldBase.id><#if model.fields[0].id&&field_index!=1></#if>if(${model.varName}.${fieldBase.showName}!=null){
                  SET("${fieldBase.columnName}=${model.varName}.${fieldBase.showName}");
                  }</#if>
                 </#list>
                WHERE("${field.columnName}=<#noparse>#{</#noparse>${field.name}}");
            }
        }.toString();
    }
}
</#if>
</#list>