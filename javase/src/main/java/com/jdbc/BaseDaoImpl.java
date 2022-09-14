package com.jdbc;

import com.reflect.Teacher;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  BaseDaoImpl {

    public List getRows(String sql, Object[] params, Class clazz) {
        List<Object> list = new ArrayList();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = MysqlUtils.getConnection();
            assert connection != null;
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            //获取查询的数据集相关信息
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取一行数据的列数
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Object o = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //从集合中获取某一列的值
                    Object fieldVal = resultSet.getObject(i + 1);
                    //获取列名称
                    String fieldName = metaData.getColumnName(i + 1).toLowerCase();
                    //获取类字段属性
                    Field declaredField = clazz.getDeclaredField(fieldName);
                    //获取的字段的set方法
                    Method method = clazz.getMethod(getSetName(fieldName), declaredField.getType());
                    //判断数据库中的字段数据类型是否number
                    if (fieldVal instanceof Number) {
                        Number fVal = (Number) fieldVal;
                        //获取对象中的字段类型
                        String name = declaredField.getType().getName();
                        if ("int".equals(name) || "java.lang.Inter".equals(name)) {
                            method.invoke(o, fVal.intValue());
                        } else if ("byte".equals(name) || "java.lang.Byte".equals(name)) {
                            method.invoke(o, fVal.byteValue());
                        } else if ("short".equals(name) || "java.lang.Short".equals(name)) {
                            method.invoke(o, fVal.shortValue());
                        } else if ("long".equals(name) || "java.lang.Long".equals(name)) {
                            method.invoke(o, fVal.longValue());
                        } else if ("float".equals(name) || "java.lang.Float".equals(name)) {
                            method.invoke(o, fVal.floatValue());
                        } else if ("double".equals(name) || "java.lang.Double".equals(name)) {
                            method.invoke(o, fVal.doubleValue());
                        }
                    } else {
                        method.invoke(o, fieldVal);
                    }
                }
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlUtils.closeConnection(connection, preparedStatement);
        }
        return list;
    }

    public String getSetName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public void save(String sql, List<Object> params, Class clazz) {
        Connection connection = MysqlUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(i, 0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
    }

    public static void main(String[] args) {
        List<Object> rows = new BaseDaoImpl().getRows("select * from Teacher", null, Teacher.class);
        for (Object obj : rows) {
            Teacher teacher = (Teacher) obj;
            System.out.println(teacher);
        }
    }
}
