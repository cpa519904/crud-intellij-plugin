package com.github.mars05.crud.intellij.plugin.base;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.UUID;

/**
 * @author xiaoyu
 */
public abstract class Base {
    private String author;
    private String datetime;
    private int ormType;
    private String comment;
    private String name;
    private String serialVersionUID;

    /**
     * 生成serialVersionUID
     *
     * @return
     */
    protected String getSerialVersionUID() {
        return String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()))+"L";
    }

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public Base(String comment, String name) {
        this.comment = comment;
        this.name = name;
    }

    public String getPackage() {
        return StringUtils.substringBeforeLast(name, ".");
    }

    public abstract Set<String> getImports();

    public String getComment() {
        return comment;
    }

    public String getSimpleName() {

        String simpleName = name.lastIndexOf(".") == -1 ? name : StringUtils.substringAfterLast(name, ".");
        if(simpleName.startsWith("t_")){
            simpleName=simpleName.replaceFirst("t_","");
        }
        return simpleName;
    }

    public String getSimpleMapperName() {
        return getSimpleName()+"Mapper";
    }

    public String getVarName() {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, getSimpleName());
    }

    public String getName() {
        return name;
    }

    public void setOrmType(int ormType) {
        this.ormType = ormType;
    }

    public int getOrmType() {
        return ormType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialVersionUID(String serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }
}
