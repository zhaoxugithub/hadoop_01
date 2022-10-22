package com.old.jdbc;

import com.old.reflect.Teacher;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBUtilTest {

    private static Connection connection = null;

    static {
        connection = MysqlUtils.getConnection();
    }

    public void testQueryRunner() throws SQLException {

        String sql = "select * from Teacher where Tid = ?";
        QueryRunner runner = new QueryRunner();
        Teacher query = runner.query(connection, sql, new BeanHandler<>(Teacher.class), "01");
        System.out.println(query);
        connection.close();
    }

    public void testListQuery() throws SQLException {
        String sql = "select * from Teacher";
        QueryRunner runner = new QueryRunner();
        List<Teacher> query = runner.query(connection, sql, new BeanListHandler<>(Teacher.class));
        query.forEach(System.out::println);
        connection.close();
    }

    public void testArrayQuery() throws SQLException {
        String sql = "select * from Teacher";
        QueryRunner runner = new QueryRunner();
        //只能返回一条数，数据里面是字段
        Object[] query = runner.query(connection, sql, new ArrayHandler());
        for (Object o : query) {
            System.out.println(o);
        }
        connection.close();
    }

    public void testArrayListQuery() throws SQLException {
        String sql = "select * from Teacher";
        QueryRunner runner = new QueryRunner();
        //只能返回一条数，数据里面是字段
        List<Object[]> list = runner.query(connection, sql, new ArrayListHandler());
        list.forEach(x -> System.out.println(x[0] + "----" + x[1]));
        connection.close();
    }

    public void testMapQuery() throws SQLException {
        String sql = "select * from Teacher";
        QueryRunner runner = new QueryRunner();
        //只能返回一条数，数据里面是字段
        Map<String, Object> query = runner.query(connection, sql, new MapHandler());
        query.entrySet().forEach(System.out::println);
        connection.close();
    }

    public void testScalaQuery() throws SQLException {
        String sql = "select count(*) from Teacher";
        QueryRunner runner = new QueryRunner();
        //只能返回一条数，数据里面是字段
        Object query = runner.query(connection, sql, new ScalarHandler<>());
        System.out.println(query);
        connection.close();
    }

    public void testMyQuery() throws SQLException {
        String sql = "select * from Teacher where Tid = ?";
        QueryRunner runner = new QueryRunner();
        //只能返回一条数，数据里面是字段
        Teacher query = runner.query(connection, sql, new ResultSetHandler<Teacher>() {
            @Override
            public Teacher handle(ResultSet resultSet) throws SQLException {
                Teacher teacher = new Teacher();
                String tid = resultSet.getString(1);
//                String tname = resultSet.getString("Tname");
                teacher.setTid(tid);
//                teacher.setTname(tname);
                System.out.println("teacher");
                return teacher;
            }
        }, "01");
        System.out.println(query);
        connection.close();
    }

    public void insert() throws SQLException {
        String sql = "insert into Teacher(TId,Tname) values(?,?)";
        QueryRunner runner = new QueryRunner();
        runner.update(connection, sql, "4", "2");
        connection.close();
    }

    public void update() throws SQLException {
        String sql = "update Teacher set Tname = ? where Tid = ?";
        QueryRunner runner = new QueryRunner();
        runner.update(connection, sql, "name", "4");
        connection.close();
    }

    public void delete() throws SQLException {

        String sql = "delete from Teacher where Tid = ?";
        QueryRunner runner = new QueryRunner();
        runner.update(connection, sql, "4");
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        DBUtilTest dbUtilTest = new DBUtilTest();
        dbUtilTest.delete();
    }
}
