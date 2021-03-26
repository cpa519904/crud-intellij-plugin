package com.github.mars05.crud.intellij.plugin.modelext;

import com.github.mars05.crud.intellij.plugin.base.Base;
import com.github.mars05.crud.intellij.plugin.base.Field;
import com.github.mars05.crud.intellij.plugin.base.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mapper extends Base {

    private Model model;
    private BaseMapper baseMapper;

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public Mapper(String comment, String name, Model model,BaseMapper baseMapper) {
        super(comment, name);
        this.model = model;
        this.baseMapper = baseMapper;
        setOrmType(model.getOrmType());
    }

    public Model getModel() {
        return model;
    }

    @Override
    public Set<String> getImports() {
        Set<String> imports = new HashSet<>();
        imports.add(model.getName());
        if(null!=baseMapper){
            imports.add(baseMapper.getName());
        }
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
