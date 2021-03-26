package com.github.mars05.crud.intellij.plugin.util;

import com.github.mars05.crud.intellij.plugin.base.*;
import com.github.mars05.crud.intellij.plugin.modelext.*;
import com.google.common.base.CaseFormat;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author xiaoyu
 */
public class PsiFile30Utils {
    private static FreemarkerConfiguration freemarker = new FreemarkerConfiguration("/templates");

    public static void createPOMXML(Project project, VirtualFile root, Selection selection) {
        try {
            VirtualFile virtualFile = root.createChildData(project, "pom.xml");
            StringWriter sw = new StringWriter();
            Template template = freemarker.getTemplate("pom.ftl");
            template.process(selection, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createSwagger(Project project, VirtualFile root, Selection selection) {
        try {
            VirtualFile virtualFile = root.createChildData(project, "Swagger2Config.java");
            StringWriter sw = new StringWriter();
            Template template = freemarker.getTemplate("Swagger2Config.ftl");
            template.process(selection, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void createSuperDal(Project project, VirtualFile packageDir, Selection selection,SuperDal superDal) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, "SuperDal.java");
            StringWriter sw = new StringWriter();
            Template template = freemarker.getTemplate("mybatisext/SuperDal.ftl");
            template.process(selection, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void createBaseMapper(Project project, VirtualFile packageDir, Selection selection, BaseMapper baseMapper) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project,  "BaseMapper.java");
            StringWriter sw = new StringWriter();
            Template template = freemarker.getTemplate("mybatisext/BaseMapper.ftl");

            template.process(selection, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createApplicationJava(Project project, VirtualFile root, Selection selection) {
        try {
            VirtualFile virtualFile = root.createChildData(project, "Application.java");
            StringWriter sw = new StringWriter();
            Template template = freemarker.getTemplate("Application.java.ftl");
            template.process(selection, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createApplicationYml(Project project, VirtualFile root, Selection selection) {
        try {
            VirtualFile virtualFile = root.createChildData(project, "application.yml");
            StringWriter sw = new StringWriter();
            Template template = freemarker.getTemplate("application.yml.ftl");
            template.process(selection, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createMapperXml(Project project, VirtualFile packageDir, Mapper mapper) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, mapper.getSimpleName() + ".xml");
            StringWriter sw = new StringWriter();
            Template template = freemarker.getTemplate("mybatisext/mapperXml.ftl");
            template.process(mapper, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createModel(Project project, VirtualFile packageDir, Model model, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, model.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatisext/model.ftl";
            model.setAuthor(selection.getAuthor());
            model.setDatetime(selection.getDatetime());
            Template template = freemarker.getTemplate(templateName);
            template.process(model, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createMapper(Project project, VirtualFile packageDir, Mapper mapper, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, mapper.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatisext/mapper.ftl";
            Template template = freemarker.getTemplate(templateName);
            mapper.setAuthor(selection.getAuthor());
            mapper.setDatetime(selection.getDatetime());
            template.process(mapper, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createDal(Project project, VirtualFile packageDir, Dal dal, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, dal.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatisext/dal.ftl";
            Template template = freemarker.getTemplate(templateName);
            dal.setAuthor(selection.getAuthor());
            dal.setDatetime(selection.getDatetime());
            template.process(dal, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));

            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createService(Project project, VirtualFile packageDir, Service service, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, service.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatisext/service.ftl";
            service.setAuthor(selection.getAuthor());
            service.setDatetime(selection.getDatetime());
            Template template = freemarker.getTemplate(templateName);
            template.process(service, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));

            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createServiceImpl(Project project, VirtualFile packageDir, Service service, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, service.getSimpleName() + "Impl.java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatisext/service_impl.ftl";
            service.setAuthor(selection.getAuthor());
            service.setDatetime(selection.getDatetime());
            Template template = freemarker.getTemplate(templateName);
            template.process(service, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));

            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createController(Project project, VirtualFile packageDir, Controller controller, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, controller.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatisext/controller.ftl";
            controller.setAuthor(selection.getAuthor());
            controller.setDatetime(selection.getDatetime());
            Template template = freemarker.getTemplate(templateName);
            template.process(controller, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));

            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static VirtualFile createPackageDir(String packageName, String moduleRootPath) {
        packageName = "src/main/java/" + packageName;
        String path = FileUtil.toSystemIndependentName(moduleRootPath + "/" + StringUtil.replace(packageName, ".", "/"));
        new File(path).mkdirs();
        return LocalFileSystem.getInstance().refreshAndFindFileByPath(path);
    }

    public static void createCrud(Project project, Selection selection, String moduleRootPath) {
        List<Table> tables = selection.getTables();
        for (Table table : tables) {
            //BaseMapper 接口
            String baseMapperPackage = selection.getBaseMapperPackage();
            if (baseMapperPackage == null) {
                continue;
            }
            VirtualFile baseMapperPackageDir = createPackageDir(baseMapperPackage, moduleRootPath);
            if (!StringUtils.isBlank(baseMapperPackage)) {
                baseMapperPackage += ".";
            }
            BaseMapper baseMapper = new BaseMapper(table.getComment(), baseMapperPackage +"BaseMapper" );

            baseMapper.setOrmType(selection.getOrmType());

            PsiFile30Utils.createBaseMapper(project, baseMapperPackageDir,selection, baseMapper);




            //SupperDal 生成
            String superDalPackage = selection.getSuperDalPackage();
            if (superDalPackage == null) {
                return;
            }
            VirtualFile superDalPackageDir = createPackageDir(superDalPackage, moduleRootPath);
            if (!StringUtils.isBlank(superDalPackage)) {
                superDalPackage += ".";
            }

            SuperDal superDal = new SuperDal("",superDalPackage +"SuperDal" ,baseMapper);
            superDal.setOrmType(selection.getOrmType());
            PsiFile30Utils.createSuperDal(project, superDalPackageDir,selection, superDal);


            //model生成
            List<Column> columns = table.getColumns();
            List<Field> fields = new ArrayList<>();
            for (Column column : columns) {
                Field field = new Field(column.getComment(), JavaTypeUtils.convertType(column.getType()), column.getName(),column.getTypeName());
                field.setId(column.isId());
                fields.add(field);
            }
            String modelPackage = selection.getModelExtPackage();
            if (modelPackage == null) {
                return;
            }
            VirtualFile modelPackageDir = createPackageDir(modelPackage, moduleRootPath);
            if (!StringUtils.isBlank(modelPackage)) {
                modelPackage += ".";
            }
            Model model = new Model(table.getComment(), modelPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName())+"Model", table.getTableName(), fields);
            model.setOrmType(selection.getOrmType());
            PsiFile30Utils.createModel(project, modelPackageDir, model, selection);

            //生成Mapper 接口
            String mapperPackage = selection.getMapperPackage();
            if (mapperPackage == null) {
                continue;
            }

            VirtualFile mapperPackageDir = createPackageDir(mapperPackage, moduleRootPath);
            if (!StringUtils.isBlank(mapperPackage)) {
                mapperPackage += ".";
            }
            Mapper mapper = new Mapper(table.getComment(), mapperPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "Mapper", model,baseMapper);


            PsiFile30Utils.createMapper(project, mapperPackageDir, mapper, selection);


            //mybatis生成mapper.xml
            String mapperDir = selection.getMapperDir();
            if (StringUtils.isNotBlank(mapperDir)) {
                String path = FileUtil.toSystemIndependentName(mapperDir);
                new File(path).mkdirs();
                VirtualFile virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByPath(path);
                PsiFile30Utils.createMapperXml(project, virtualFile, mapper);
            }

            //dal生成
            String dalPackage = selection.getDalPackage();
            if (dalPackage == null) {
                continue;
            }
            VirtualFile daoPackageDir = createPackageDir(dalPackage, moduleRootPath);
            if (!StringUtils.isBlank(dalPackage)) {
                dalPackage += ".";
            }
            Dal dal = new Dal(table.getComment(), dalPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "Dal", model,mapper,superDal);
            PsiFile30Utils.createDal(project, daoPackageDir, dal, selection);

            //service生成
            //接口
            String servicePackage = selection.getServiceExtPackage();
            if (servicePackage == null) {
                continue;
            }
            VirtualFile servicePackageDir = createPackageDir(servicePackage, moduleRootPath);
            if (!StringUtils.isBlank(servicePackage)) {
                servicePackage += ".";
            }
            Service service = new Service(table.getComment(), servicePackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "Service", dal);
            PsiFile30Utils.createService(project, servicePackageDir, service, selection);
            //实现
            String serviceImplPackage = servicePackage + "impl";
            VirtualFile serviceImplPackageDir = createPackageDir(serviceImplPackage, moduleRootPath);
            service.getImports().add(service.getDal().getName());
            service.getImports().add(service.getName());
            PsiFile30Utils.createServiceImpl(project, serviceImplPackageDir, service, selection);
            //controller生成
            String controllerPackage = selection.getControllerExtPackage();
            if (controllerPackage == null) {
                continue;
            }
            VirtualFile controllerPackageDir = createPackageDir(controllerPackage, moduleRootPath);
            if (!StringUtils.isBlank(controllerPackage)) {
                controllerPackage += ".";
            }
            Controller controller = new Controller(table.getComment(), controllerPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "Controller", service);
            PsiFile30Utils.createController(project, controllerPackageDir, controller, selection);
        }
    }


    public static void setProps(Properties props) throws TemplateException {
        freemarker.setSettings(props);
    }

}
