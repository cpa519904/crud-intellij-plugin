package ${package};

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "${tableName}")
public class ${simpleName} {
<#list fields as field>
    /**
     * ${field.comment}
     */
    <#if field.id>
    @Id
    </#if>
    @Column(name = "${field.columnName}")
    private ${field.typeSimpleName} ${field.name};
</#list>
}