package ${package};

import lombok.Data;
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
@Data
public class ${simpleName} {
<#list fields as field>
    /**
     * ${field.comment}
     */
    private ${field.typeSimpleName} ${field.name};
</#list>
}