package sample.Utility;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class Utility {

    private static String url = "";
    private static String userName = "";
    private static String password = "";
    private static String dbName = "";
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection connection = null;

    public static void connect() throws SQLException, ClassNotFoundException {

        try {
            connection = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {

            throw e;
        }
    }

    public static void disconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static ResultSet execute(String query) throws Exception {

        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {

            connect();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {

            throw e;
        } finally {
            if (resultSet != null) {

                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }

            disconnect();
        }

        return crs;
    }

    public static void update(String sqlStmt) throws Exception {

        Statement stmt = null;
        try {
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (Exception e) {

            throw e;
        } finally {
            if (stmt != null) {

                stmt.close();
            }
            disconnect();
        }
    }

    public static boolean executeProcedure(String query, String name, String addr, Integer ssn, Integer salary, String dateJoin, String role) throws Exception{
        CallableStatement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            connect();
            stmt = connection.prepareCall(query);
            stmt.setString(1, name);
            stmt.setString(2, addr);
            stmt.setInt(3, ssn);
            stmt.setInt(4, salary);
            stmt.setString(5, dateJoin);
            stmt.setString(6, role);
            boolean result = stmt.execute();
            return result;
        } catch (SQLException e) {

            throw e;
        } finally {
            if (resultSet != null) {

                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }

            disconnect();
        }
    }
}
