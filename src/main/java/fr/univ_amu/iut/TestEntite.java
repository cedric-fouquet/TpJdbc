package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc

import fr.univ_amu.iut.beans.Etudiant;

import java.sql.*;
import java.util.ArrayList;

public class TestEntite {
    static final String req = "SELECT * " +
            "FROM ETUDIANT " ;
    static final ArrayList<Etudiant> Etudiants = new ArrayList<>();
    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");

            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
                Etudiant currentEtudiant = new Etudiant();
                currentEtudiant.setNumEt(rset.getInt("NUM_ET"));
                currentEtudiant.setNomEt(rset.getString("NOM_ET"));
                currentEtudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                currentEtudiant.setVilleEt(rset.getString("VILLE_ET"));
                currentEtudiant.setCpEt(rset.getString("CP_ET"));
                currentEtudiant.setAnnee(rset.getInt("ANNEE"));
                currentEtudiant.setGroupe(rset.getInt("GROUPE"));
                Etudiants.add(currentEtudiant);
            }
            for (Etudiant Etu:Etudiants) {
                System.out.println(Etu.toString());

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");

        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
