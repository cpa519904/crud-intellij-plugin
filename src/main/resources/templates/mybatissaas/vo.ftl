package ${package};

import java.io.Serializable;
import lombok.Data;
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
@Data
public class ${simpleName} implements Serializable {
 private static final long serialVersionUID = ${serialVersionUID};
<#list fields as field>
    /**
     * ${field.comment}
     */
    private ${field.typeSimpleName} ${field.name};
</#list>
}