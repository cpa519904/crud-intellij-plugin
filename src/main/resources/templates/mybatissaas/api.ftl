package ${package};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
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
<#assign model=service.model />
<#assign dto=service.dto />
<#list model.fields as field>
    <#if field.id>
@RestController
@Api(tags = "${model.comment}")
public class ${simpleName} {
    @Resource
    private ${service.simpleName} ${service.varName};

    @GetMapping("/v1.0/${model.varName}/{${field.name}}")
    @ApiOperation("通过ID查询单个${model.comment}")
    public Mono<${vo.simpleName}> get(@ApiParam("${field.name}") @PathVariable("${field.name}") ${field.typeSimpleName} ${field.name}) {
        ${dto.simpleName} ${dto.varName} =${service.varName}.getByPrimaryKey(${field.name});
        ${vo.simpleName} ${vo.varName} =new ${vo.simpleName}();
        BeanUtils.copyProperties(${dto.varName},${vo.varName});
        return Mono.just(${vo.varName});
    }


    @PostMapping("/v1.0/${model.varName}")
    @ApiOperation("新增${model.comment}")
    public Mono<String> insert(@RequestBody ${dto.simpleName} ${model.varName}) {
        ${service.varName}.add(${model.varName});
        return Mono.just("success");
    }

    @PutMapping("/v1.0/${model.varName}")
    @ApiOperation("修改${model.comment}")
    public Mono<String> update(@RequestBody ${dto.simpleName} ${model.varName}) {
        ${service.varName}.update(${model.varName});
        return Mono.just("success");
    }

    @DeleteMapping("/v1.0/${model.varName}/{${field.name}}")
    @ApiOperation("通过ID删除单个${model.comment}")
    public Mono<String> del(@ApiParam("${field.name}") @PathVariable("${field.name}") ${field.typeSimpleName} ${field.name}) {
        ${service.varName}.deleteByPrimaryKey(${field.name});
        return Mono.just("success");
    }
}
    </#if>
</#list>