package com.gettable;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu peng bo
 * @date 2018/5/7
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "system");
        DatabaseMetaData dbMetaData = connection.getMetaData();
        ResultSet tables = dbMetaData.getTables(null, "SYSTEM", "%", new String[]{"TABLE"});
        List<String> list = new ArrayList<>();
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            if ("T_TEST".equals(tableName)) {
                String a1 = tables.getString(1);
                String a2 = tables.getString(2);
                String a3 = tables.getString(3);
                String a4 = tables.getString(4);
                String a5 = tables.getString(5);
                String remarks = tables.getString("REMARKS");

                list.add(tableName);

                ResultSet rs = dbMetaData.getColumns(null, "SYSTEM", tableName, null);
                Map<String, String> map = new HashMap<>();
                while (rs.next()) {
                    String columnName = rs.getString("COLUMN_NAME");
                    String type = rs.getString("TYPE_NAME");
                    int DATA_TYPE = rs.getInt("DATA_TYPE");
                    int COLUMN_SIZE = rs.getInt("COLUMN_SIZE");
                    String DECIMAL_DIGITS = rs.getString("DECIMAL_DIGITS");
                    int NULLABLE = rs.getInt("NULLABLE");
                    String REMARKS = rs.getString("REMARKS");
                    map.put(columnName, type);
                }
            }
        }

    }
}
