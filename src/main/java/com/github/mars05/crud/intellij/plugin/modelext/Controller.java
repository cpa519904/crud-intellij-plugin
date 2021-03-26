package com.github.mars05.crud.intellij.plugin.modelext;

import com.github.mars05.crud.intellij.plugin.base.Base;
import com.github.mars05.crud.intellij.plugin.base.Field;
import com.github.mars05.crud.intellij.plugin.base.Model;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaoyu
 */
public class Controller extends Base {


    private Service service;

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public Controller(String comment, String name, Service service) {
        super(comment, name);
        this.service = service;
        setOrmType(service.getOrmType());
    }

    public Service getService() {
        return service;
    }

    @Override
    public Set<String> getImports() {
        Set<String> imports = new HashSet<>();
        imports.add(service.getName());
        Model model = service.getDal().getModel();
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
