package com.project.ie303group03.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

// apply singleton pattern
public class SQLServer {
    private String username;
    private String password;
    private String serverName;
    private String databaseName;
    private int port;
    private Connection con;
    static private SQLServer server;

    private SQLServer(String username, String password, String serverName, int port, String databaseName) {
        this.username = username;
        this.password = password;
        this.port = port;
        this.serverName = serverName;
        this.databaseName = databaseName;

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
                    server = new SQLServer("sa", "sa", "DESKTOP-M15KQ9A\\SQLEXPRESS", 1433, "XET_TOT_NGHIEP");
                }
            }
        } else if (server.getConnection().isClosed()) {
            server = new SQLServer("sa", "sa", "DESKTOP-M15KQ9A\\SQLEXPRESS", 1433, "XET_TOT_NGHIEP");
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

//    public ResultSet query(String sql) {
//
//    }
}
