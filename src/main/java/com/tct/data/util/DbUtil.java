package com.tct.data.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Hannibal
 * @Date: 2021/7/7 13:57
 * @Version 1.0
 * @description
 */
@Slf4j
public class DbUtil {
    /**
     * 获取连接
     *
     * @param url
     * @param user
     * @param password
     * @param driverName
     * @return
     */
    public static Connection getConnection(String url, String user, String password, String driverName) {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            log.error("加载数据库驱动失败",e);
        } catch (Exception e) {
            log.error("连接数据库失败",e);
        }
        return conn;
    }

    /**
     * 查询数据
     *
     * @param connection
     * @param sql
     * @return
     */
    public static List<Map> getData(Connection connection, String sql) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map> dataList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1, "王五");
            resultSet = preparedStatement.executeQuery();
            //获取字段名称
            ResultSetMetaData rsd = resultSet.getMetaData();
            int columnCount = rsd.getColumnCount();
            //遍历查询结果集
            while (resultSet.next()) {
                Map ones = new HashMap();
                for (int i = 1; i <= columnCount; i++) {
                    ones.put(rsd.getColumnName(i), resultSet.getString(i));
                }
                dataList.add(ones);
            }
        } catch (SQLException e) {
            log.error("sql：{}执行异常",sql,e);
        } finally {
            CloseUtil.close(resultSet, connection, preparedStatement);
        }
        return dataList;
    }

    /**
     * 查询数据
     *
     * @param url
     * @param user
     * @param password
     * @param driverName
     * @param sql
     * @return
     */
    public static List<Map> getData(String url, String user, String password, String driverName, String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map> dataList = new ArrayList<>();
        try {
            //加载数据库驱动
            Class.forName(driverName);
            //通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1, "王五");
            resultSet = preparedStatement.executeQuery();
            //获取字段名称
            ResultSetMetaData rsd = resultSet.getMetaData();
            int columnCount = rsd.getColumnCount();
            //遍历查询结果集
            while (resultSet.next()) {
                Map ones = new HashMap();
                for (int i = 1; i <= columnCount; i++) {
                    ones.put(rsd.getColumnName(i), resultSet.getString(i));
                }
                dataList.add(ones);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(resultSet, connection, preparedStatement);
        }
        return dataList;
    }


    public static void main(String[] args) {
        Connection connection = getConnection("jdbc:sqlserver://10.2.1.142:1433;DatabaseName=v5x",
                "OABI", "OABI", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        List<Map> list = getData(connection, "select top 10 * from dbo.DOC_RESOURCES ");
        System.out.println(list);
    }
}
