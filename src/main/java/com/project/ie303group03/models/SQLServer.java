package com.project.ie303group03.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

// apply singleton pattern
public class SQLServer {
    private final String username = "sa";
    private final String password = "sa";
    private final String serverName = "DESKTOP-M15KQ9A\\SQLEXPRESS";
    private final String databaseName = "XET_TOT_NGHIEP";
    private int port = 1433;
    private Connection con;
    static private SQLServer server;

    private SQLServer() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(this.username);
        ds.setPassword(this.password);
        ds.setServerName(this.serverName);
        ds.setPortNumber(this.port);
        ds.setDatabaseName(this.databaseName);
        ds.setDatabaseName(this.databaseName);
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
            server = new SQLServer();
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

    public ResultSet query(String sql) {
        return null;
    }
}
