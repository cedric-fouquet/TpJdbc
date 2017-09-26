package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc

import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.*;
import java.util.ArrayList;

public class TestAsso1 {
    static final String req = "SELECT * " +
            "FROM PROF ,MODULE " +
            "WHERE PROF.MAT_SPEC = MODULE.CODE";
    static final ArrayList<Prof> Profs = new ArrayList<>();
    static final ArrayList<Module> Modules = new ArrayList<>();
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
                Prof currentProf = new Prof();
                Module currentModule = new Module();
                currentModule.setCode(rset.getString("CODE"));
                currentModule.setLibelle(rset.getString("LIBELLE"));
                currentModule.sethCoursPrev(rset.getInt("H_COURS_PREV"));
                currentModule.sethCoursRea(rset.getInt("H_COURS_REA"));
                currentModule.sethTpPrev(rset.getInt("H_TP_PREV"));
                currentModule.sethTpRea(rset.getInt("H_TP_REA"));
                currentModule.setDiscipline(rset.getString("DISCIPLINE"));
                currentModule.setCoefCc(rset.getInt("COEFF_CC"));
                currentModule.setCoefTest(rset.getInt("COEFF_TEST"));



                currentProf.setNumProf(rset.getInt("NUM_PROF"));
                currentProf.setNomProf(rset.getString("NOM_PROF"));
                currentProf.setPrenomProf(rset.getString("PRENOM_PROF"));
                currentProf.setVilleProf(rset.getString("VILLE_PROF"));
                currentProf.setCpProf(rset.getString("CP_PROF"));
                currentProf.setAdrProf(rset.getString("ADR_PROF"));

                currentModule.setResponsable(currentProf);
                currentProf.setMatSpec(currentModule);
                Profs.add(currentProf);
            }
            for (Prof prof:Profs) {
                System.out.println(prof.toString());

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
