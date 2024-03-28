package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class IrveDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public IrveDAO() {
		super();
	}
	

	public Irve get(String nomAmenageur) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Irve returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM irve WHERE nom_amenageur = ?");
			ps.setString(1, nomAmenageur);
			rs = ps.executeQuery();
			if (rs.next()) 
			{
				Amenageur a = new Amenageur(rs.getString("nom_amenageur"),
						rs.getString("siren_amenageur"),
						rs.getString("contact_amenageur"));
				
				Operateur o = new Operateur(rs.getString("nom_operateur"),
						rs.getString("contact_operateur"),
						rs.getString("telephone_operateur"));
				
				ArrayList<String> tdp = new ArrayList<String>();
				if(rs.getString("prise_type_ef").equals("TRUE"))
					tdp.add("prise_type_ef");
				if(rs.getString("prise_type_2").equals("TRUE"))
					tdp.add("prise_type_2");
				if(rs.getString("prise_type_combo_ccs").equals("TRUE"))
					tdp.add("prise_type_combo_ccs");
				if(rs.getString("prise_type_chademo").equals("TRUE"))
					tdp.add("prise_type_chademo");
				if(rs.getString("prise_type_autre").equals("TRUE"))
					tdp.add("prise_type_autre");
					
				
				returnValue = new Irve(	rs.getString("nom_station"),
						rs.getString("nom_enseigne"),
						rs.getString("implantation_station"),
						rs.getString("adresse_station"),
						rs.getString("puissance_nominale"),
						tdp,
						rs.getString("horaires"),
						rs.getString("consolidated_longitude"),
						rs.getString("consolidated_latitude"),
						rs.getString("tarification"),
						rs.getString("station_deux_roues").equals("TRUE"),
						o,
						a
						);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	public ArrayList<Irve> getList(String nom) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Irve> returnValue = new ArrayList<Irve>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM irve WHERE nom_amenageur LIKE ? OR nom_operateur LIKE ? OR nom_station LIKE ?;");
			ps.setString(1, nom);
			ps.setString(2, nom);
			ps.setString(3, nom);
			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				Amenageur a = new Amenageur(rs.getString("nom_amenageur"),
						rs.getString("siren_amenageur"),
						rs.getString("contact_amenageur"));
				
				Operateur o = new Operateur(rs.getString("nom_operateur"),
						rs.getString("contact_operateur"),
						rs.getString("telephone_operateur"));
				
				ArrayList<String> tdp = new ArrayList<String>();
				if(rs.getString("prise_type_ef").equals("TRUE"))
					tdp.add("prise_type_ef");
				if(rs.getString("prise_type_2").equals("TRUE"))
					tdp.add("prise_type_2");
				if(rs.getString("prise_type_combo_ccs").equals("TRUE"))
					tdp.add("prise_type_combo_ccs");
				if(rs.getString("prise_type_chademo").equals("TRUE"))
					tdp.add("prise_type_chademo");
				if(rs.getString("prise_type_autre").equals("TRUE"))
					tdp.add("prise_type_autre");
				
				returnValue.add(new Irve(	rs.getString("nom_station"),
						rs.getString("nom_enseigne"),
						rs.getString("implantation_station"),
						rs.getString("adresse_station"),
						rs.getString("puissance_nominale"),
						tdp,
						rs.getString("horaires"),
						rs.getString("consolidated_longitude"),
						rs.getString("consolidated_latitude"),
						rs.getString("tarification"),
						rs.getString("station_deux_roues").equals("TRUE"),
						o,
						a
						));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	public ArrayList<Irve> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Irve> returnValue = new ArrayList<Irve>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM irve");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				Amenageur a = new Amenageur(rs.getString("nom_amenageur"),
						rs.getString("siren_amenageur"),
						rs.getString("contact_amenageur"));
				
				Operateur o = new Operateur(rs.getString("nom_operateur"),
						rs.getString("contact_operateur"),
						rs.getString("telephone_operateur"));
				
				ArrayList<String> tdp = new ArrayList<String>();
				if(rs.getString("prise_type_ef").equals("TRUE"))
					tdp.add("prise_type_ef");
				if(rs.getString("prise_type_2").equals("TRUE"))
					tdp.add("prise_type_2");
				if(rs.getString("prise_type_combo_ccs").equals("TRUE"))
					tdp.add("prise_type_combo_ccs");
				if(rs.getString("prise_type_chademo").equals("TRUE"))
					tdp.add("prise_type_chademo");
				if(rs.getString("prise_type_autre").equals("TRUE"))
					tdp.add("prise_type_autre");
				
				returnValue.add(new Irve(	rs.getString("nom_station"),
						rs.getString("nom_enseigne"),
						rs.getString("implantation_station"),
						rs.getString("adresse_station"),
						rs.getString("puissance_nominale"),
						tdp,
						rs.getString("horaires"),
						rs.getString("consolidated_longitude"),
						rs.getString("consolidated_latitude"),
						rs.getString("tarification"),
						rs.getString("station_deux_roues").equals("TRUE"),
						o,
						a
						));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	public static void main(String[] args) throws SQLException {
		IrveDAO irveDAO = new IrveDAO();
		ArrayList<Irve> irves = irveDAO.getList("%Zunder%");
		irves.forEach(irve -> System.out.println(irve));
		
		System.out.println("END");
	}

}