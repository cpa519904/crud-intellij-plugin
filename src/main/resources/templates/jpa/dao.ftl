package ${package};

import org.springframework.data.jpa.repository.JpaRepository;
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
public interface ${simpleName} extends JpaRepository<${model.simpleName}, ${field.typeSimpleName}> {

}
    </#if>
</#list>