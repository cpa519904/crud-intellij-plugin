package com.github.mars05.crud.intellij.plugin.modelext;

import com.github.mars05.crud.intellij.plugin.base.Base;
import com.github.mars05.crud.intellij.plugin.base.Field;
import com.github.mars05.crud.intellij.plugin.base.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaoyu
 */
public class Service extends Base {
    private Dal dal;
    private Model model;

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public Service(String comment, String name, Dal dal) {
        super(comment, name);
        this.dal = dal;
        this.model = dal.getModel();
        setOrmType(dal.getOrmType());
    }

    public Dal getDal() {
        return dal;
    }

    public Model getModel() {
        return model;
    }

    private Set<String> imports = new HashSet<>();

    @Override
    public Set<String> getImports() {
        imports.add(dal.getName());
        imports.add(model.getName());
        List<Field> fields = model.getFields();
        for (Field field : fields) {
            if (field.isId() && field.isImport()) {
                imports.add(field.getTypeName());
                break;
            }
        }
        return imports;
    }

}
