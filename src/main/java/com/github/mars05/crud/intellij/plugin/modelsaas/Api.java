package com.github.mars05.crud.intellij.plugin.modelsaas;

import com.github.mars05.crud.intellij.plugin.base.Base;
import com.github.mars05.crud.intellij.plugin.base.Field;
import com.github.mars05.crud.intellij.plugin.base.Model;
import com.github.mars05.crud.intellij.plugin.base.Vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaoyu
 */
public class Api extends Base {


    private Service service;
    private Vo vo;

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public Api(String comment, String name, Service service,Vo vo) {
        super(comment, name);
        this.service = service;
        this.vo = vo;

        setOrmType(service.getOrmType());
    }

    public Service getService() {
        return service;
    }

    public Vo getVo() {
        return vo;
    }

    @Override
    public Set<String> getImports() {
        Set<String> imports = new HashSet<>();
        imports.add(service.getName());
        Model model = service.getModel();
        imports.add(model.getName());
        imports.add(vo.getName());

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
