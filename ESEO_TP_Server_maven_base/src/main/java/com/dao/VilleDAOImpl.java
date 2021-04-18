package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	private JDBCConfiguration jdbc;

	public VilleDAOImpl(JDBCConfiguration jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public ArrayList<Ville> getAllCities() {
		Connection conn = jdbc.getConn();
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		Statement st;
		
		try {
			st = conn.createStatement();
			String query = "SELECT * FROM ville_france";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				listVille.add(new Ville(rs.getString("Code_commune_INSEE"),
										rs.getString("Nom_commune"),
										rs.getString("Code_postal"),
										rs.getString("Libelle_acheminement"),
										rs.getString("Latitude"),
										rs.getString("Longitude")));
			}
			st.close();
			return listVille;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		

	}

	@Override
	public Ville getCityByCodePost(String codeCommune) {
		Connection conn = jdbc.getConn();
		PreparedStatement pst;
		
		try {
			pst = conn.prepareStatement("SELECT * FROM ville_france WHERE Code_Commune_INSEE=?;");
			pst.setString(1, codeCommune);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new Ville(rs.getString("Code_commune_INSEE"),
										rs.getString("Nom_commune"),
										rs.getString("Code_postal"),
										rs.getString("Libelle_acheminement"),
										rs.getString("Latitude"),
										rs.getString("Longitude"));
			}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateCity(Ville ville) {
		Connection conn = jdbc.getConn();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("UPDATE ville_france SET Nom_Commune = ?, Code_postal = ?, Libelle_acheminement = ?, Latitude = ?, Longitude = ?  WHERE Code_Commune_INSEE=?;");
			pst.setString(1, ville.getNomCommune());
			pst.setString(2, ville.getCodePostal());
			pst.setString(3, ville.getLibelle());
			pst.setString(4, ville.getLatitude());
			pst.setString(5, ville.getLongitude());
			pst.setString(6, ville.getCodeCommune());
            pst.executeUpdate();
            conn.commit();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addCity(Ville ville) {
		Connection conn = jdbc.getConn();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("INSERT INTO ville_france VALUES (Code_Commune_INSEE = ?, Nom_Commune = ?, Code_postal = ?, Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?, Longitude = ?);");
			pst.setString(1, ville.getCodeCommune());
			pst.setString(2, ville.getNomCommune());
			pst.setString(3, ville.getCodePostal());
			pst.setString(4, ville.getLibelle());
			pst.setString(5, ville.getLigne5());
			pst.setString(6, ville.getLatitude());
			pst.setString(7, ville.getLongitude());
            pst.executeUpdate();
            conn.commit();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCity(String codeCommune) {
		Connection conn = jdbc.getConn();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("DELETE FROM ville_france WHERE Code_Commune_INSEE = ?");
			pst.setString(1, codeCommune);
            pst.executeUpdate();
            conn.commit();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
