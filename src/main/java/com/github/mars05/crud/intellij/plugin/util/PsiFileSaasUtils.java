package com.github.mars05.crud.intellij.plugin.util;

import com.github.mars05.crud.intellij.plugin.base.*;
import com.github.mars05.crud.intellij.plugin.modelsaas.*;
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
public class PsiFileSaasUtils {
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
            String templateName;
            if (model.getOrmType() == OrmType.JPA) {
                templateName = "jpa/model.ftl";
            } else if (model.getOrmType() == OrmType.MYBATIS) {
                templateName = "mybatis/model.ftl";
            } else if (model.getOrmType() == OrmType.MYBATIS_EXT) {
                templateName = "mybatisext/model.ftl";
            } else if (model.getOrmType() == OrmType.MYBATIS_SAAS) {
                templateName = "mybatissaas/model.ftl";
            } else {
                templateName = "mybatisplus/model.ftl";
            }
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
            String templateName = "mybatissaas/mapper.ftl";
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

    private static void createProvider(Project project, VirtualFile packageDir, Provider provider, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, provider.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatissaas/provider.ftl";
            Template template = freemarker.getTemplate(templateName);
            provider.setAuthor(selection.getAuthor());
            provider.setDatetime(selection.getDatetime());
            template.process(provider, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void createDto(Project project, VirtualFile packageDir, Dto dto, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, dto.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatissaas/dto.ftl";
            Template template = freemarker.getTemplate(templateName);
            dto.setAuthor(selection.getAuthor());
            dto.setDatetime(selection.getDatetime());
            template.process(dto, sw);
            virtualFile.setBinaryContent(sw.toString().getBytes(CrudUtils.DEFAULT_CHARSET));
            CrudUtils.addWaitOptimizeFile(virtualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createVo(Project project, VirtualFile packageDir, Vo vo, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, vo.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatissaas/vo.ftl";
            Template template = freemarker.getTemplate(templateName);
            vo.setAuthor(selection.getAuthor());
            vo.setDatetime(selection.getDatetime());
            template.process(vo, sw);
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
            String templateName = "mybatissaas/service.ftl";
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
            String templateName = "mybatissaas/service_impl.ftl";
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
            String templateName = "mybatissaas/controller.ftl";
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

    private static void createApi(Project project, VirtualFile packageDir, Api api, Selection selection) {
        try {
            VirtualFile virtualFile = packageDir.createChildData(project, api.getSimpleName() + ".java");
            StringWriter sw = new StringWriter();
            String templateName = "mybatissaas/api.ftl";
            api.setAuthor(selection.getAuthor());
            api.setDatetime(selection.getDatetime());
            Template template = freemarker.getTemplate(templateName);
            template.process(api, sw);
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
//            String baseMapperPackage = selection.getBaseMapperPackage();
//            if (baseMapperPackage == null) {
//                continue;
//            }
//            VirtualFile baseMapperPackageDir = createPackageDir(baseMapperPackage, moduleRootPath);
//            if (!StringUtils.isBlank(baseMapperPackage)) {
//                baseMapperPackage += ".";
//            }
//            BaseMapper baseMapper = new BaseMapper(table.getComment(), baseMapperPackage +"BaseMapper" );
//
//            baseMapper.setOrmType(selection.getOrmType());
//
//            PsiFileSaasUtils.createBaseMapper(project, baseMapperPackageDir,selection, baseMapper);




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
            PsiFileSaasUtils.createModel(project, modelPackageDir, model, selection);




            //生成Provider 接口
            String providerPackage = selection.getProviderPackage();
            if (providerPackage == null) {
                continue;
            }

            VirtualFile providerPackageDir = createPackageDir(providerPackage, moduleRootPath);
            if (!StringUtils.isBlank(providerPackage)) {
                providerPackage += ".";
            }
            Provider provider = new Provider(table.getComment(), providerPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "Provider",model);

            PsiFileSaasUtils.createProvider(project, providerPackageDir, provider, selection);

            //生成Mapper 接口
            String mapperPackage = selection.getMapperPackage();
            if (mapperPackage == null) {
                continue;
            }

            VirtualFile mapperPackageDir = createPackageDir(mapperPackage, moduleRootPath);
            if (!StringUtils.isBlank(mapperPackage)) {
                mapperPackage += ".";
            }
            Mapper mapper = new Mapper(table.getComment(), mapperPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "ModelMapper", model,provider);
            PsiFileSaasUtils.createMapper(project, mapperPackageDir, mapper, selection);



            //dto生成
            //接口
            String dtoPackage = selection.getDtoPackage();
            if (dtoPackage == null) {
                continue;
            }
            VirtualFile dtoPackageDir = createPackageDir(dtoPackage, moduleRootPath);
            if (!StringUtils.isBlank(dtoPackage)) {
                dtoPackage += ".";
            }

            Dto dto = new Dto(table.getComment(), dtoPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName())+"Dto", table.getTableName(), fields);
            PsiFileSaasUtils.createDto(project, dtoPackageDir, dto, selection);
            //vo生成
            //接口
            String voPackage = selection.getVoPackage();
            if (voPackage == null) {
                continue;
            }
            VirtualFile voPackageDir = createPackageDir(voPackage, moduleRootPath);
            if (!StringUtils.isBlank(voPackage)) {
                voPackage += ".";
            }

            Vo vo = new Vo(table.getComment(), voPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName())+"Vo", table.getTableName(), fields);
            PsiFileSaasUtils.createVo(project, voPackageDir, vo, selection);

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
            Service service = new Service(table.getComment(), servicePackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "Service",mapper,dto);
            PsiFileSaasUtils.createService(project, servicePackageDir, service, selection);
            //实现
            String serviceImplPackage = servicePackage + "impl";
            VirtualFile serviceImplPackageDir = createPackageDir(serviceImplPackage, moduleRootPath);
            service.getImports().add(service.getMapper().getName());
            service.getImports().add(service.getName());
            PsiFileSaasUtils.createServiceImpl(project, serviceImplPackageDir, service, selection);
//            //controller生成
//            String apiPackage = selection.getApiPackage();
//            if (apiPackage == null) {
//                continue;
//            }
//            VirtualFile apiPackageDir = createPackageDir(apiPackage, moduleRootPath);
//            if (!StringUtils.isBlank(apiPackage)) {
//                apiPackage += ".";
//            }
//            Api api = new Api(table.getComment(), apiPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "Api", service,vo);
//            PsiFileSaasUtils.createApi(project, apiPackageDir, api, selection);

            //controller生成
            String controllerPackage = selection.getControllerExtPackage();
            if (controllerPackage == null) {
                continue;
            }
            VirtualFile controllerPackageDir = createPackageDir(controllerPackage, moduleRootPath);
            if (!StringUtils.isBlank(controllerPackage)) {
                controllerPackage += ".";
            }
            Controller controller = new Controller(table.getComment(), controllerPackage + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()) + "Api", service,vo);
            PsiFileSaasUtils.createController(project, controllerPackageDir, controller, selection);
        }
    }


    public static void setProps(Properties props) throws TemplateException {
        freemarker.setSettings(props);
    }

}
