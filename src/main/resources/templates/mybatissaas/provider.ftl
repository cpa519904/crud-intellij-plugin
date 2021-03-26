package ${package};

import org.apache.ibatis.jdbc.SQL;
<#list imports as import>
import ${import};
</#list>
import org.apache.commons.lang3.StringUtils;
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
public class ${simpleName} {

    /**
    * 更新单个${model.comment}
    *
    * @param  ${model.varName} ${model.comment}
    *
    */
    public String updateByPrimaryKeySelective(${model.simpleName} ${model.varName}){
        return new SQL() {
            {
                UPDATE("${model.tableName}");
        <#list model.fields as field><#if !field.id>
                <#if field.typeName =="java.lang.String">if(StringUtils.isNotEmpty(${model.varName}.${field.showName}())){
                    SET("${field.columnName}=<#noparse>#{</#noparse>${field.name}}");
                }<#else>if(${model.varName}.${field.showName}()!=null){
                    SET("${field.columnName}=<#noparse>#{</#noparse>${field.name}}");
                }</#if></#if>
        </#list>
                WHERE("${field.columnName}=<#noparse>#{</#noparse>${field.name}}");
            }
        }.toString();
    }
    /**
    * 插入单个${model.comment}
    *
    * @param ${model.varName} ${model.comment}
    *
    */
    public String insertSelective(${model.simpleName} ${model.varName}){
        return new SQL() {
        {
                INSERT_INTO("${model.tableName}");
        <#list model.fields as field>
                <#if !field.id><#if field.typeName =="java.lang.String">if(StringUtils.isNotEmpty(${model.varName}.${field.showName}())){
                    VALUES("${field.columnName}","<#noparse>#{</#noparse>${field.name}}");
                }<#else>if(${model.varName}.${field.showName}()!=null){
                    VALUES("${field.columnName}","<#noparse>#{</#noparse>${field.name}}");
                }</#if>
        </#if>
        </#list>
            }
        }.toString();
    }
    /**
    * 查询${model.comment}列表
    *
    * @param ${model.varName} ${model.comment}
    *
    */
    public String selectProvider(${model.simpleName} ${model.varName}){
    return new SQL() {
        {
                SELECT("<#list model.fields as field><#if field_index!=0>,</#if>${field.columnName}</#list>");
                FROM("${model.tableName}");
        <#list model.fields as field><#if !field.id>
                <#if field.typeName =="java.lang.String">if(StringUtils.isNotEmpty(${model.varName}.${field.showName}())){
                    WHERE("${field.columnName}=<#noparse>#{</#noparse>${field.name}}");
                }<#else>if(${model.varName}.${field.showName}()!=null){
                    WHERE("${field.columnName}=<#noparse>#{</#noparse>${field.name}}");
                }</#if>
        </#if>
        </#list>
            }
        }.toString();
    }
}
</#if>
</#list>
