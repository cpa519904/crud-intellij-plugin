package com.github.mars05.crud.intellij.plugin.modelext;


import com.github.mars05.crud.intellij.plugin.base.Base;

import java.util.HashSet;
import java.util.Set;

public class SuperDal extends Base {
    BaseMapper baseMapper;

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public SuperDal(String comment, String name, BaseMapper baseMapper) {
        super(comment, name);
        this.baseMapper = baseMapper;
        setOrmType(baseMapper.getOrmType());
    }

    public BaseMapper getBaseMapper() {
        return baseMapper;
    }

    @Override
    public Set<String> getImports() {
        Set<String> imports = new HashSet<>();
        imports.add(baseMapper.getName());
        return imports;
    }
}