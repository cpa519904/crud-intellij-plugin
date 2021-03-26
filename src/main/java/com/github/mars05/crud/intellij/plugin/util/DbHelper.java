package com.github.mars05.crud.intellij.plugin.util;

import com.github.mars05.crud.intellij.plugin.base.Column;
import com.github.mars05.crud.intellij.plugin.base.Table;
import com.mysql.jdbc.StringUtils;

import java.awt.image.ImageProducer;
import java.sql.*;
import java.util.*;

/**
 * @author xiaoyu
 */
public class DbHelper {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String db;
    private Properties props;

    public DbHelper(String host, Integer port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        props = new Properties();
        props.put("user", this.username);
        props.put("password", this.password);
        props.setProperty("remarks", "true");
        props.put("useInformationSchema", "true");
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false", props);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private Connection getConnection(String database) {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + database + "?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false", props);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public List<String> getDatabases() {
        Connection conn = getConnection();
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet catalogs = metaData.getCatalogs();
            List<String> rs = new ArrayList<>();
            while (catalogs.next()) {
                String db = catalogs.getString("TABLE_CAT");
                if (org.apache.commons.lang3.StringUtils.equalsIgnoreCase(db, "information_schema")) {
                    continue;
                }
                rs.add(db);
            }
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public List<String> getAllTableName(String database) {
        db = database;
        Connection conn = getConnection(db);
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            List<String> ls = new ArrayList<>();
            while (rs.next()) {
                String s = rs.getString("TABLE_NAME");
                ls.add(s);
            }
            return ls;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public Table getTable(String tableName) {
        Connection conn = getConnection(db);
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getTables(null, "", tableName, new String[]{"TABLE"});
            Table table = null;
            if (rs.next()) {
                table = new Table(rs.getString("REMARKS"), tableName, getAllColumn(tableName, conn));
            }
            return table;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    private List<Column> getAllColumn(String tableName, Connection conn) {
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
            String primaryKey = null;
            while (primaryKeys.next()) {
                primaryKey = primaryKeys.getString("COLUMN_NAME");
            }

            StringBuilder queryBuf = new StringBuilder("select * FROM ");
            queryBuf.append(tableName);
            queryBuf.append(" WHERE 1 = 2 ");
            PreparedStatement preparedStatement=null;
            Map<String,String> map = new HashMap<>();
            try {
                preparedStatement= conn.prepareStatement(queryBuf.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData metaDataItem = resultSet.getMetaData();
                for (int i = 1; i <= metaDataItem.getColumnCount(); i++) {
                    map.put(metaDataItem.getColumnName(i ),String.format("%s(%s)",metaDataItem.getColumnTypeName(i ).toLowerCase(),metaDataItem.getColumnDisplaySize(i)));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }



            ResultSet rs = metaData.getColumns(null, null, tableName, null);
            List<Column> ls = new ArrayList<>();
            while (rs.next()) {

                String columnName = rs.getString("COLUMN_NAME");
                Column column = new Column(rs.getString("REMARKS"), columnName, rs.getInt("DATA_TYPE"),map.get(columnName));
                if (!StringUtils.isNullOrEmpty(primaryKey) && columnName.equals(primaryKey)) {
                    column.setId(true);
                }
                ls.add(column);
            }
            return ls;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    public static void main(String[] args) {
//        String host="192.168.19.81";
//        Integer port=3306;
//        String username="root";
//        String password="yry112233";
//        DbHelper dbHelper = new DbHelper(host, port, username, password);
//        dbHelper.db="yskj_system";
//        Connection connection = dbHelper.getConnection("yskj_system");
//        List<Column> t_tc_company = dbHelper.getAllColumn("t_tc_company", connection);
//        System.out.println(new Gson().toJson(t_tc_company));

//        try{
//
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from t_tc_company where 1 = 2");
//            ResultSetMetaData resultSetMetaData = preparedStatement.executeQuery().getMetaData();
//
//            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
//
//                System.out.println("数据库实例名:"+resultSetMetaData.getCatalogName(i ));
//                System.out.println("表名:"+resultSetMetaData.getTableName(i ));
//                System.out.println("java类型:"+resultSetMetaData.getColumnClassName(i ));
//                System.out.println("数据库类型:"+resultSetMetaData.getColumnTypeName(i ).toLowerCase());
//                System.out.println("字段名称:"+resultSetMetaData.getColumnName(i ));
//                System.out.println("字段长度:"+resultSetMetaData.getColumnDisplaySize(i ));
//                System.out.println("getColumnType:"+resultSetMetaData.getColumnType(i ));
//                System.out.println("getPrecision:"+resultSetMetaData.getPrecision(i ));
//                System.out.println("getScale:"+resultSetMetaData.getScale(i ));
//                System.out.println("getSchemaName:"+resultSetMetaData.getSchemaName(i ));
//                System.out.println("getScale:"+resultSetMetaData.getScale(i ));
//            }
//        } catch (Exception e) {
//           e.printStackTrace();
//        }

    }

}
