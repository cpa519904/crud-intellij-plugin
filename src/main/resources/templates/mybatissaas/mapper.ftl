package ${package};
import org.apache.ibatis.annotations.*;
import java.util.List;
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
@Mapper
public interface ${simpleName}{
    public final static String SQL_SELECT_ALL = "<#list model.fields as field>${field.columnName}<#if field_has_next>,</#if></#list>";
 <#list model.fields as field>
  <#if field.id>

   /**
   * 插入${model.comment}
   *
   * @param ${model.varName} ${model.comment}
   * @return
   */
   @Insert("INSERT INTO ${model.tableName}(<#list model.fields as field><#if !field.id><#if model.fields[0].id&&field_index!=1>,</#if>${field.columnName}</#if></#list>) VALUES (<#list model.fields as field><#if !field.id><#if model.fields[0].id&&field_index!=1>,</#if><#noparse>#{</#noparse>${field.name}}</#if></#list>)")
   int insert(${model.simpleName} ${model.varName});

   /**
   * 插入${model.comment}
   *
   * @param ${model.varName} ${model.comment}
   * @return
   */
   @InsertProvider(type = ${provider.simpleName}.class, method = "insertSelective")
   int insertSelective(${model.simpleName} ${model.varName});

   /**
   * 更新${model.comment}
   *
   * @param ${model.varName} ${model.comment}
   * @return
   */
   @Update("UPDATE ${model.tableName} SET <#list model.fields as field><#if !field.id><#if model.fields[0].id&&field_index!=1>,</#if>${field.columnName}=<#noparse>#{</#noparse>${field.name}}</#if></#list> WHERE ${field.columnName}=<#noparse>#{</#noparse>${field.name}}")
   int update(${model.simpleName} ${model.varName});

   /**
   * 更新${model.comment}
   *
   * @param ${model.varName} ${model.comment}
   * @return
   */
   @UpdateProvider(type = ${provider.simpleName}.class, method = "updateByPrimaryKeySelective")
   int updateByPrimaryKeySelective(${model.simpleName} ${model.varName});

   /**
   *通过${field.name} 删除单个${model.comment}
   *
   * @param ${field.name} ${field.comment}
   * @return
   */
   @Delete("DELETE FROM ${model.tableName}  WHERE  ${field.columnName}=<#noparse>#{</#noparse>${field.name}}")
   int deleteByPrimaryKey(${field.typeSimpleName} ${field.name});

   /**
   * 通过${field.name} 查询单个${model.comment}
   *
   * @param ${field.name} ${field.comment}
   * @return {@link ${model.simpleName}}
   */
   @Select("SELECT  "+SQL_SELECT_ALL+"  FROM  ${model.tableName} WHERE ${field.columnName}=<#noparse>#{</#noparse>${field.name}}")
   ${model.simpleName} selectByPrimaryKey(${field.typeSimpleName} ${field.name});

   /**
   * 查询列表${model.comment}
   *
   * @return
   */
   @Select("SELECT "+SQL_SELECT_ALL+" FROM  ${model.tableName}")
   List<${model.simpleName}> selectList();

   /**
   * Provider 查询列表${model.comment}
   *
   * @return
   */
   @SelectProvider(type = ${provider.simpleName}.class, method = "selectProvider")
   List<${model.simpleName}> selectProvider(${model.simpleName} ${model.varName});
  </#if>
 </#list>
}
