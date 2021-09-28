package com.tct.data.util;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Hannibal
 * @Date: 2021/7/7 13:58
 * @Version 1.0
 * @description
 */
public class CloseUtil {

    public static void close(Object... objs) {
        for (Object obj : objs) {
            if (obj == null) {
                continue;
            }
            try {
                if (obj instanceof InputStream) {
                    ((InputStream) obj).close();
                } else if (obj instanceof OutputStream) {
                    ((OutputStream) obj).close();
                } else if (obj instanceof Writer) {
                    ((Writer) obj).close();
                } else if (obj instanceof ByteArrayOutputStream) {
                    ((ByteArrayOutputStream) obj).close();
                }else if (obj instanceof Connection) {
                    ((Connection) obj).close();
                }else if (obj instanceof PreparedStatement) {
                    ((PreparedStatement) obj).close();
                }else if (obj instanceof ResultSet) {
                    ((ResultSet) obj).close();
                }
            } catch (IOException e) {
                System.out.println("关闭流失败");
            }catch (SQLException e1) {
                System.out.println("关闭数据库连接失败");
            }
        }
    }
}
