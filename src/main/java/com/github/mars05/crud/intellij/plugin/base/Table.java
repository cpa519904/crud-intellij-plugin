package com.github.mars05.crud.intellij.plugin.base;

import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author xiaoyu
 */
public class Table {
    private String comment;
    private String name;
    private String tableName;
    private String tablePrefix="t_";
    private List<Column> columns;

    public Table(String comment, String name, List<Column> columns) {
        this.comment = comment;
        this.name = name;
        this.tableName = name;
        this.columns = columns;
    }

    public Table(String tablePrefix,String comment, String name, List<Column> columns) {
        this.tablePrefix = tablePrefix;
        this.comment = comment;
        this.tableName = name;
        this.name = name;
        this.columns = columns;
    }

    public String getName() {
        if(StringUtils.isEmpty(tablePrefix)){
            return this.name;
        }
        if(this.name.startsWith(tablePrefix)){
            this.name=this.name.replaceFirst(tablePrefix,"");
        }
        return this.name;

    }

    public String getComment() {
        return comment;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }
}
