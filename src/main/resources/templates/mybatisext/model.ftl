package ${package};

import lombok.Data;
import java.io.ObjectStreamClass;
import javax.persistence.*;
import java.io.Serializable;

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
@Table(name = "${tableName}")
public class ${simpleName} implements Serializable {
private static final long serialVersionUID = 1L;
<#list fields as field>
    /**
    * ${field.comment}
    */
    <#if field.id>
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    </#if>
    @Column(name = "${field.columnName}")
    private ${field.typeSimpleName} ${field.name};
</#list>
}