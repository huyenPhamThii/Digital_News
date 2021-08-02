/*
 * Copyright(C) 2021, Pham Thi Huyen
 * J3.L.P0004
 * Digital news
 * 
 * Record of change:    
 * DATE          Version    AUTHOR      DESCRIPTION
 * 2021-05-14    1.0        HuyenPT     First Implement
 * 2021-05-17    2.0        HuyenPT     Second Implement
 * 2021-05-18    3.0        HuyenPT     Third Implement
 * 2021-05-23    4.0        HuyenPT     Four Inplement
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * This class contains methods to connect to database and close the connection:
 * getConnection, close connection, resultSet and prepareStatement
 *
 * <p>
 * Bugs: None
 *
 * @author Pham Thi Huyen
 */
public class DBContext {

    private InitialContext initial;
    private Context context;
    private String dbName;
    private String serverName;
    private String portNumber;
    private String userName;
    private String password;

    /**
     * Parameterless constructor used to initialize a digital object
     */
    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            dbName = context.lookup("dbName").toString();
            serverName = context.lookup("serverName").toString();
            portNumber = context.lookup("portNumber").toString();
            userName = context.lookup("userName").toString();
            password = context.lookup("password").toString();
        } catch (NamingException e) {
        }

    }

    /**
     * This method is get connection to database
     *
     * @return connection <code>java.sql.Connection</code>
     * @throws Exception when any error occurs
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userName, password);
    }

    /**
     * This method closes connection if it still open
     *
     * @param con Connection <code>java.sql.Connetion</code> object
     * @throws java.sql.SQLException
     */
    public void closeCon(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * This method closes prepareStament if it still open
     *
     * @param ps preareSatement <code>java.sql.PrerareStatement</code> object
     * @throws java.sql.SQLException
     */
    public void closePS(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * This method closes resultSet if it still open
     *
     * @param rs resultSet <code>java.sql.ResultSet</code> object
     * @throws java.sql.SQLException
     */
    public void closeRs(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }
}
