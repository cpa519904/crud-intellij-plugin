package com.github.mars05.crud.intellij.plugin.util;

import com.github.mars05.crud.intellij.plugin.base.Table;
import com.github.mars05.crud.intellij.plugin.setting.Conn;

import java.util.List;

/**
 * @author xiaoyu
 */
public class Selection {
    private String projectType;
    private int ormType;
    private Conn conn;
    private String db;
    private List<Table> tables;
    private String groupId;
    private String artifactId;
    private String version;
    private String pkg;

    private String daoPackage;
    private String dalPackage;
    private String providerPackage;
    private String dtoPackage;
    private String voPackage;
    private String superDalPackage;
    private String servicePackage;
    private String serviceExtPackage;
    private String controllerPackage;
    private String controllerExtPackage;
    private String apiPackage;
    private String mapperDir;
    private String modelPackage;
    private String mapperPackage;
    private String baseMapperPackage;
    private String modelExtPackage;
    private String author;
    private String datetime;

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Conn getConn() {
        return conn;
    }

    public void setConn(Conn conn) {
        this.conn = conn;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPackage() {
        return pkg;
    }

    public void setPackage(String pkg) {
        this.pkg = pkg;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getMapperDir() {
        return mapperDir;
    }

    public void setMapperDir(String mapperDir) {
        this.mapperDir = mapperDir;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setOrmType(int ormType) {
        this.ormType = ormType;
    }

    public int getOrmType() {
        return ormType;
    }

    public String getDalPackage() {
        return dalPackage;
    }

    public void setDalPackage(String dalPackage) {
        this.dalPackage = dalPackage;
    }

    public String getServiceExtPackage() {
        return serviceExtPackage;
    }

    public void setServiceExtPackage(String serviceExtPackage) {
        this.serviceExtPackage = serviceExtPackage;
    }

    public String getControllerExtPackage() {
        return controllerExtPackage;
    }

    public void setControllerExtPackage(String controllerExtPackage) {
        this.controllerExtPackage = controllerExtPackage;
    }

    public String getModelExtPackage() {
        return modelExtPackage;
    }

    public void setModelExtPackage(String modelExtPackage) {
        this.modelExtPackage = modelExtPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getSuperDalPackage() {
        return superDalPackage;
    }

    public void setSuperDalPackage(String superDalPackage) {
        this.superDalPackage = superDalPackage;
    }

    public String getBaseMapperPackage() {
        return baseMapperPackage;
    }

    public void setBaseMapperPackage(String baseMapperPackage) {
        this.baseMapperPackage = baseMapperPackage;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDtoPackage() {
        return dtoPackage;
    }

    public void setDtoPackage(String dtoPackage) {
        this.dtoPackage = dtoPackage;
    }

    public String getVoPackage() {
        return voPackage;
    }

    public void setVoPackage(String voPackage) {
        this.voPackage = voPackage;
    }

    public String getApiPackage() {
        return apiPackage;
    }

    public void setApiPackage(String apiPackage) {
        this.apiPackage = apiPackage;
    }

    public String getProviderPackage() {
        return providerPackage;
    }

    public void setProviderPackage(String providerPackage) {
        this.providerPackage = providerPackage;
    }
}
