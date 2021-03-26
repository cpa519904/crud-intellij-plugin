package ${package};
import org.apache.ibatis.annotations.Mapper;
<#list imports as import>
    import ${import};
</#list>
/**
 * <dl>
 *    <dt><b>Title:</b></dt>
 *    <dd>
 *    ${comment}
 *    </dd>
 *    <dt><b>Description:</b></dt>
 *    <dd>
 *    	<p>
 *    </dd>
 *
 * @author ${author}
 * @date ${datetime}
 */
@Mapper
public interface  ${simpleName} extends BaseMapper<${model.simpleName}> {
    public final static String SQL_SELECT_ALL = "<#list model.fields as field>${field.columnName}<#if field_has_next>,</#if></#list>";

}