package com.github.mars05.crud.intellij.plugin.base;

/**
 * @author xiaoyu
 */
public class Column {
    private String comment;
    private String name;
    private String typeName;
    private int type;
    private boolean id;

    /**
     * @param comment 列注释
     * @param name    列名
     * @param type    列类型
     */
    public Column(String comment, String name, int type) {
        this.comment = comment;
        this.name = name;
        this.type = type;
    }


    /**
     * @param comment 列注释
     * @param name    列名
     * @param type    列类型
     */
    public Column(String comment, String name, int type,String typeName) {
        this.comment = comment;
        this.name = name;
        this.type = type;
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public boolean isId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }
}
