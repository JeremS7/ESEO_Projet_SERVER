package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

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
	public ArrayList<Ville> getCityByCodePost(String codeCommune) {
		Connection conn = jdbc.getConn();
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		PreparedStatement pst;
		
		try {
			pst = conn.prepareStatement("SELECT * FROM ville_france WHERE Code_Commune_INSEE=?;");
			pst.setString(1, codeCommune);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				listVille.add(new Ville(rs.getString("Code_commune_INSEE"),
										rs.getString("Nom_commune"),
										rs.getString("Code_postal"),
										rs.getString("Libelle_acheminement"),
										rs.getString("Latitude"),
										rs.getString("Longitude")));
			}
			pst.close();
			return listVille;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
