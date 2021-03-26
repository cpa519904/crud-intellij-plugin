package com.github.mars05.crud.intellij.plugin.modelext;

import com.github.mars05.crud.intellij.plugin.base.Base;

import java.util.HashSet;
import java.util.Set;

public class BaseMapper  extends Base {

    /**
     * @param comment 类的注释
     * @param name    类的全限定名
     */
    public BaseMapper(String comment, String name) {
        super(comment, name);
    }

    @Override
    public Set<String> getImports() {
        Set<String> imports = new HashSet<>();
        return imports;
    }
}