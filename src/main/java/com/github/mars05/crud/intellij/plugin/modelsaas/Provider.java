package com.github.mars05.crud.intellij.plugin.modelsaas;

import com.github.mars05.crud.intellij.plugin.base.Base;
import com.github.mars05.crud.intellij.plugin.base.Field;
import com.github.mars05.crud.intellij.plugin.base.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Provider extends Base {
    private Model model;

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public Provider(String comment, String name, Model model) {
        super(comment, name);
        this.model = model;
    }


    public Model getModel() {
        return model;
    }


    private Set<String> imports = new HashSet<>();

    @Override
    public Set<String> getImports() {
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
