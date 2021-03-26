package ${package};

<#if ormType==0 || ormType==2>
import org.mybatis.spring.annotation.MapperScan;
</#if>

<#if ormType==3>
import tk.mybatis.spring.annotation.MapperScan;
</#if>
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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
@SpringBootApplication
<#if ormType==0 || ormType==2>
@MapperScan("${package}.dao")
</#if>
<#if ormType==3>
@MapperScan("${package}.mapper.main")
</#if>
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
