package com.github.mars05.crud.intellij.plugin.modelsaas;

import com.github.mars05.crud.intellij.plugin.base.Base;
import com.github.mars05.crud.intellij.plugin.base.Dto;
import com.github.mars05.crud.intellij.plugin.base.Field;
import com.github.mars05.crud.intellij.plugin.base.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaoyu
 */
public class Service extends Base {
    private Mapper mapper;
    private Model model;
    private Dto dto;

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public Service(String comment, String name, Mapper mapper,Dto dto) {
        super(comment, name);
        this.mapper = mapper;
        this.dto = dto;
        this.model = mapper.getModel();
        setOrmType(mapper.getOrmType());
    }

    public Mapper getMapper() {
        return mapper;
    }

    public Model getModel() {
        return model;
    }

    public Dto getDto() {
        return dto;
    }

    private Set<String> imports = new HashSet<>();

    @Override
    public Set<String> getImports() {
        imports.add(mapper.getName());
        imports.add(model.getName());
        imports.add(dto.getName());
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
