package com.old.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBCTool {
    public static final String JDBC_IMPALA_DRIVER = "com.cloudera.impala.jdbc41.Driver";
    public static final String JDBC_IMPALA_URL = "jdbc:impala://39.98.119.103:21050/zhugeio;AuthMech=0";//诸葛私有部署
    public static final String JDBC_IMPALA_USERNAME = "";
    public static final String JDBC_IMPALA_PASSWORD = "";

    public static List<Map> getConnection(String queryStr) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        List<Map> list = new ArrayList<>();
        try {
            Class.forName(JDBC_IMPALA_DRIVER);
            connection = DriverManager.getConnection(JDBC_IMPALA_URL);
            st = connection.createStatement();
            rs = st.executeQuery(queryStr);
            while (rs.next()) {
                Map<String, Object> resultMap = new HashMap<>();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    resultMap.put(metaData.getColumnLabel(i), rs.getObject(i));
                }
                list.add(resultMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * @Description: 事件总表
     * @Param:
     * @return:
     * @Author: serendipity
     * @Date: 2021/9/6
     */
    public static void selectBUserEventAll(int appId) {
        String sql = String.format("select * from zanalytics.b_user_event_all_%s where begin_date >= 1630909827", String.valueOf(appId));
        List<Map> connection = getConnection(sql);
        connection.forEach(System.out::println);
    }

    /**
     * @Description: 事件属性表
     * @Param:
     * @return:
     * @Author: serendipity
     * @Date: 2021/9/6
     */
    public static void selectBUserEventAttrAPPID(int appId) {
        String sql = String.format("select * from zanalytics.b_user_event_attr_%s", String.valueOf(appId));
        List<Map> connection = getConnection(sql);
        connection.forEach(System.out::println);
    }

    /**
     * @Description: 用户表
     * @Param:
     * @return:
     * @Author: serendipity
     * @Date: 2021/9/6
     */
    public static void bUserAPPID(int appId) {
        String sql = String.format("select * from zanalytics.b_user_%s where begin_date >= 1630909827 ", String.valueOf(appId));
        List<Map> connection = getConnection(sql);
        System.out.println(connection.size());
        connection.forEach(System.out::println);
    }

    /**
     * @Description: 用户属性表
     * @Param:
     * @return:
     * @Author: serendipity
     * @Date: 2021/9/6
     */
    public static void bUserPropertyAPPID(int appId) {
        String sql = String.format("select * from zanalytics.b_user_property_%s", String.valueOf(appId));
        List<Map> connection = getConnection(sql);
        System.out.println(connection.size());
        connection.forEach(System.out::println);
    }

    /**
     * @Description: 硬件设备表
     * @Param:
     * @return:
     * @Author: serendipity
     * @Date: 2021/9/6
     */
    public static void bDeviceAPPID(int appId) {
        String sql = String.format("select * from zanalytics.b_device_%s", String.valueOf(appId));
        List<Map> connection = getConnection(sql);
        connection.forEach(System.out::println);
    }


    public static void main(String[] args) {
        bUserAPPID(127);
//        bUserPropertyAPPID(109);
//        bDeviceAPPID(109);
//        selectBUserEventAll(109);
    }
}



