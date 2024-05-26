package com.project.ie303group03.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

// apply singleton pattern
public class SQLServer {
    private final String USERNAME = "sa";
    private final String PASSWORD = "sa";
    private final String SERVER_NAME = "DINH-KHANH";
    private final String DATABASE_NAME = "XET_TOT_NGHIEP";
    private final int PORT = 1433;
    private Connection con;
    static private SQLServer server;

    private SQLServer() {
        this.createConnection();
    }

    private void createConnection() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(this.USERNAME);
        ds.setPassword(this.PASSWORD);
        ds.setServerName(this.SERVER_NAME);
        ds.setPortNumber(this.PORT);
        ds.setDatabaseName(this.DATABASE_NAME);
        ds.setTrustServerCertificate(true);

        try {
            this.con = ds.getConnection();
            System.out.println("Connect database successfully");

        } catch(SQLServerException ex) {
            System.err.println("Error: " + ex);
        }
    }

    static public SQLServer getServerInstance() throws SQLException {
        if (server == null) {
            synchronized (SQLServer.class) {
                if (server == null) {
                    server = new SQLServer();
                }
            }
        } else if (server.getConnection().isClosed()) {
            server.createConnection();
        }

        return server;
    }

    public Connection getConnection() {
        return this.con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet select(String sql) throws SQLException {
        CallableStatement cstmt = con.prepareCall(sql);
        return cstmt.executeQuery();
    }
}
