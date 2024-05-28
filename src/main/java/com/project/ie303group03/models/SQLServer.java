package com.project.ie303group03.models;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.project.ie303group03.configs.DatabaseConfig;
import com.project.ie303group03.controllers.SinhVienController;

// apply singleton pattern
public class SQLServer {
    private final String USERNAME = DatabaseConfig.USERNAME;
    private final String PASSWORD = DatabaseConfig.PASSWORD;
    private final String SERVER_NAME = DatabaseConfig.SERVER_NAME;
    private final String DATABASE_NAME = DatabaseConfig.DATABASE_NAME;
    private final int PORT = DatabaseConfig.PORT;
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

    public void insert(SinhVienController controller) throws SQLException {
        String sql = "";
        String ketQua = controller.xetTotNghiep() ? "Đạt" : "Không đạt";

        CallableStatement cstmt = con.prepareCall("SELECT * FROM KETQUAXETTOTNGHIEP WHERE MASV=?");
        cstmt.setNString(1, controller.getSinhVien().getMaSV());
        ResultSet res = cstmt.executeQuery();

        if (!res.next()) {
            sql = "INSERT INTO KETQUAXETTOTNGHIEP(MASV, KETQUA, DEXUAT) VALUES (?, ?, ?)";
        } else {
            // Update if the record exists
            sql = "UPDATE KETQUAXETTOTNGHIEP SET KETQUA=?, DEXUAT=? WHERE MASV=?";
        }

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setNString(1, controller.getSinhVien().getMaSV());
        statement.setNString(2, ketQua);
        statement.setNString(3, String.join("", controller.getLogs()));

        if (res.next()) {
            statement.setNString(4, controller.getSinhVien().getMaSV());
        }

        statement.executeUpdate();
    }
}
