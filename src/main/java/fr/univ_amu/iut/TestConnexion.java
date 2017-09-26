package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexion {
    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");

            //stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
