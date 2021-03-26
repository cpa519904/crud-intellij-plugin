package com.github.mars05.crud.intellij.plugin.base;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author xiaoyu
 */
public class Dto extends Base {
    private String tableName;

    private List<Field> fields;

    private String serialVersionUID;

    /**
     * 生成serialVersionUID
     *
     * @return
     */
    @Override
    public String getSerialVersionUID() {
        return String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()))+"L";
    }


    /**
     * @param comment   类的注释
     * @param name      类的全限定名
     * @param tableName 表的名称
     */
    public Dto(String comment, String name, String tableName, List<Field> fields) {
        super(comment, name);
        this.tableName = tableName;
        this.fields = fields;
        this.serialVersionUID = getSerialVersionUID();
    }

    public List<Field> getFields() {
        return fields;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public Set<String> getImports() {
        Set<String> imports = new HashSet<>();
        List<Field> fields = getFields();
        for (Field field : fields) {
            if (field.isImport()) {
                imports.add(field.getTypeName());
            }
        }
        return imports;
    }
}
