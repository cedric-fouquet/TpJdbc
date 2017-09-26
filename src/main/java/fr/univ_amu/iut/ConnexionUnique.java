package fr.univ_amu.iut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by f16007622 on 21/09/17.
 */
public class ConnexionUnique {
    // Chaine de connexion
    static final String CONNECT_URL = "jdbc:mysql://mysql-nilcair.alwaysdata.net:3306/nilcair_20";
    static final String LOGIN = "nilcair_admin";
    static final String PASSWORD = "123";
    Connection connection;

    private ConnexionUnique(){
        try {
            connection = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ConnexionUnique INSTANCE = new ConnexionUnique();

    public Connection getConnection() {
        return connection;
    }

    public static ConnexionUnique getInstance()
    {
        return INSTANCE;
    }

}
