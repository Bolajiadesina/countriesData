package com.bolaji.countriesData.utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

@Service
public class CountriesUtilities {

    /**
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */

    public static Connection getConnection()
            throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Connection conn = null;
        String host = "";

        String passwords = "";
        String Instance = "";
        String usernames = "";
        //////// temp//////
        host = "";
        // hostUAT = "10.8.184.142";
        usernames = "rtuser";
        passwords = "rtuatdb123$";
        Instance = "rtdb1pdb";

        // ubslive
        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        System.out.println("Connecting to the database..." + host + " : ---- : " + usernames);
        // conn = DriverManager.getConnection(host, usernames, (passwords));
        conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@" + host + ":1521/" + Instance + "", usernames, passwords);
        System.out.println("Connected to the database");
        return conn;

    }

    /**
     * This method uses a jndi parameter to compose connection string instead of one
     * off connection that may have to be opened everytime
     * a connection is required. it it deployed on the server
     * 
     * @return connection pool
     */
    public Connection getDataBaseConnection() {
        // TODO Auto-generated method stub

        Context initCtx = null;
        DataSource ds = null;
        Connection conn = null;
        try {
            initCtx = new InitialContext();
            ds = (DataSource) initCtx.lookup("jdbc/RapidData");
            conn = ds.getConnection();
            System.out.println("Connection " + conn);
        } catch (SQLException e) {
            System.out.println("SQLException In Connection : " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception In connection : " + e.getMessage());
            e.printStackTrace();
        }
        return conn;

    }

    public static void closeConnection(Connection connection, CallableStatement callableStatement,
            ResultSet resultSet) {

        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (callableStatement != null) {
            try {
                callableStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
