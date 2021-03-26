<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${name}">

    <resultMap id="BaseMapperMap" type="${model.name}">
        <#list model.fields as field>
        <#if field.id>
        <id property="${field.name}" column="${field.columnName}"/>
        <#else>
        <result property="${field.name}" column="${field.columnName}"/>
        </#if>
        </#list>
    </resultMap>

</mapper>