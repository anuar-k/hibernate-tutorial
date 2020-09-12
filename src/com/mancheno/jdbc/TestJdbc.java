package com.mancheno.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/hb_student_tracker";
        String user = "postgres";
        String password = "postgres";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}