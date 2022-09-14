package com.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.reflect.Teacher;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * C3P0 只能配合xml配置文件一起
 */
public class C3P0Test {

    public static Connection connection;
    public static ComboPooledDataSource dataSource;

    public static void getConnection() {
        dataSource = new ComboPooledDataSource();
    }

    public static void queryData() throws SQLException {
        connection = dataSource.getConnection();
        String sql = "select * from Teacher";
        QueryRunner runner = new QueryRunner();
        List<Teacher> query = runner.query(connection, sql, new BeanListHandler<>(Teacher.class));
        query.forEach(System.out::println);
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
        queryData();
    }
}
