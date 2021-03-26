package com.github.mars05.crud.intellij.plugin.modelext;

import com.github.mars05.crud.intellij.plugin.base.Base;
import com.github.mars05.crud.intellij.plugin.base.Field;
import com.github.mars05.crud.intellij.plugin.base.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dal extends Base {

    private Model model;
    private Mapper mapper;
    private SuperDal superDal;

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public Dal(String comment, String name, Model model,Mapper mapper,SuperDal superDal) {
        super(comment, name);
        this.model = model;
        this.mapper = mapper;
        this.superDal = superDal;
        setOrmType(model.getOrmType());
    }

    public Model getModel() {
        return model;
    }

    @Override
    public Set<String> getImports() {
        Set<String> imports = new HashSet<>();
        imports.add(model.getName());
        imports.add(mapper.getName());
        imports.add(superDal.getName());
        List<Field> fields = model.getFields();
        for (Field field : fields) {
            if (field.isId() && field.isImport()) {
                imports.add(field.getTypeName());
                break;
            }
        }
        return imports;
    }

    public Mapper getMapper() {
        return mapper;
    }

    public SuperDal getSuperDal() {
        return superDal;
    }
}
