package com.github.mars05.crud.intellij.plugin.util;

import com.github.mars05.crud.intellij.plugin.base.Table;
import com.github.mars05.crud.intellij.plugin.setting.Conn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author xiaoyu
 */
public class SelectionContext {
    private static String projectType;
    private static int ormType;
    private static String datetime;
    private static String author;
    private static Conn conn;
    private static String db;
    private static List<Table> tables;
    private static String groupId;
    private static String artifactId;
    private static String version;
    private static String pkg;
    private static String modelPackage;
    private static String mapperPackage;
    private static String baseMapperPackage;
    private static String modelExtPackage;
    private static String daoPackage;
    private static String providerPackage;
    private static String dalPackage;
    private static String dtoPackage;
    private static String voPackage;
    private static String superDalPackage;
    private static String servicePackage;
    private static String serviceExtPackage;
    private static String controllerPackage;
    private static String controllerExtPackage;
    private static String apiPackage;
    private static String mapperDir;

    public static Conn getConn() {
        return conn;
    }

    public static void setConn(Conn conn) {
        SelectionContext.conn = conn;
    }

    public static String getDb() {
        return db;
    }

    public static void setDb(String db) {
        SelectionContext.db = db;
    }

    public static List<Table> getTables() {
        return tables;
    }

    public static void setTables(List<Table> tables) {
        SelectionContext.tables = tables;
    }

    public static String getProjectType() {
        return projectType;
    }

    public static void setProjectType(String projectType) {
        SelectionContext.projectType = projectType;
    }


    public static String getGroupId() {
        return groupId;
    }

    public static void setGroupId(String groupId) {
        SelectionContext.groupId = groupId;
    }

    public static String getArtifactId() {
        return artifactId;
    }

    public static void setArtifactId(String artifactId) {
        SelectionContext.artifactId = artifactId;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        SelectionContext.version = version;
    }

    public static String getPackage() {
        return pkg;
    }

    public static void setPackage(String pkg) {
        SelectionContext.pkg = pkg;
    }

    public static String getModelExtPackage() {
        return modelExtPackage;
    }

    public static void setModelExtPackage(String modelExtPackage) {
        SelectionContext.modelExtPackage = modelExtPackage;
    }

    public static String getDalPackage() {
        return dalPackage;
    }

    public static void setDalPackage(String dalPackage) {
        SelectionContext.dalPackage = dalPackage;
    }

    public static String getServiceExtPackage() {
        return serviceExtPackage;
    }

    public static void setServiceExtPackage(String serviceExtPackage) {
        SelectionContext.serviceExtPackage = serviceExtPackage;
    }

    public static String getControllerExtPackage() {
        return controllerExtPackage;
    }

    public static void setControllerExtPackage(String controllerExtPackage) {
        SelectionContext.controllerExtPackage = controllerExtPackage;
    }

    public static String getApiPackage() {
        return apiPackage;
    }

    public static void setApiPackage(String apiPackage) {
        SelectionContext.apiPackage = apiPackage;
    }

    public static String getMapperPackage() {
        return mapperPackage;
    }

    public static void setMapperPackage(String mapperPackage) {
        SelectionContext.mapperPackage = mapperPackage;
    }

    public static String getBaseMapperPackage() {
        return baseMapperPackage;
    }

    public static void setBaseMapperPackage(String baseMapperPackage) {
        SelectionContext.baseMapperPackage = baseMapperPackage;
    }

    public static String getSuperDalPackage() {
        return superDalPackage;
    }

    public static void setSuperDalPackage(String superDalPackage) {
        SelectionContext.superDalPackage = superDalPackage;
    }

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        SelectionContext.author = author;
    }

    public static String getPkg() {
        return pkg;
    }

    public static void setPkg(String pkg) {
        SelectionContext.pkg = pkg;
    }

    public static String getDatetime() {
        return datetime;
    }

    public static void setDatetime(String datetime) {
        SelectionContext.datetime = datetime;
    }

    public static void clearAllSet() {
        projectType = null;
        conn = null;
        db = null;
        tables = null;
        groupId = null;
        artifactId = null;
        version = null;
        pkg = null;
        daoPackage = null;
        dalPackage = null;
        providerPackage = null;
        dtoPackage = null;
        voPackage = null;
        superDalPackage = null;
        servicePackage = null;
        serviceExtPackage = null;
        controllerPackage = null;
        controllerExtPackage = null;
        apiPackage = null;
        mapperDir = null;
        modelPackage = null;
        mapperPackage = null;
        baseMapperPackage = null;
        modelExtPackage = null;
        author = null;
        datetime = null;
        ormType = 0;
    }

    public static Selection copyToSelection() {
        Selection selection = new Selection();
        selection.setProjectType(projectType);
        selection.setConn(conn);
        selection.setDb(db);
        selection.setTables(tables);
        selection.setGroupId(groupId);
        selection.setArtifactId(artifactId);
        selection.setVersion(version);
        selection.setPackage(pkg);
        selection.setDaoPackage(daoPackage);
        selection.setDalPackage(dalPackage);
        selection.setDalPackage(providerPackage);
        selection.setDtoPackage(dtoPackage);
        selection.setVoPackage(voPackage);
        selection.setSuperDalPackage(superDalPackage);
        selection.setServicePackage(servicePackage);
        selection.setServiceExtPackage(serviceExtPackage);
        selection.setControllerPackage(controllerPackage);
        selection.setControllerExtPackage(controllerExtPackage);
        selection.setApiPackage(apiPackage);
        selection.setMapperDir(mapperDir);
        selection.setModelPackage(modelPackage);
        selection.setMapperPackage(mapperPackage);
        selection.setBaseMapperPackage(baseMapperPackage);
        selection.setModelExtPackage(modelExtPackage);
        selection.setOrmType(ormType);
        selection.setAuthor(author);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        selection.setDatetime(LocalDateTime.now().format(formatter));
        return selection;
    }

    public static void setOrmType(int ormType) {
        SelectionContext.ormType = ormType;
    }

    public static int getOrmType() {
        return ormType;
    }

    public static String getDaoPackage() {
        return daoPackage;
    }

    public static void setDaoPackage(String daoPackage) {
        SelectionContext.daoPackage = daoPackage;
    }

    public static String getServicePackage() {
        return servicePackage;
    }

    public static void setServicePackage(String servicePackage) {
        SelectionContext.servicePackage = servicePackage;
    }

    public static String getControllerPackage() {
        return controllerPackage;
    }

    public static void setControllerPackage(String controllerPackage) {
        SelectionContext.controllerPackage = controllerPackage;
    }

    public static String getMapperDir() {
        return mapperDir;
    }

    public static void setMapperDir(String mapperDir) {
        SelectionContext.mapperDir = mapperDir;
    }

    public static void setModelPackage(String modelPackage) {
        SelectionContext.modelPackage = modelPackage;
    }

    public static String getModelPackage() {
        return modelPackage;
    }

    public static String getDtoPackage() {
        return dtoPackage;
    }

    public static void setDtoPackage(String dtoPackage) {
        SelectionContext.dtoPackage = dtoPackage;
    }

    public static String getVoPackage() {
        return voPackage;
    }

    public static void setVoPackage(String voPackage) {
        SelectionContext.voPackage = voPackage;
    }

    public static String getProviderPackage() {
        return providerPackage;
    }

    public static void setProviderPackage(String providerPackage) {
        SelectionContext.providerPackage = providerPackage;
    }
}
