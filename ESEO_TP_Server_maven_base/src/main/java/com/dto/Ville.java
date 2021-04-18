package com.dto;

import java.io.Serializable;

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Ville implements Serializable {

	/**
	 * Serial IUD for serialization.
	 */
	private static final long serialVersionUID = -8050478362033217382L;
	

	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelle;
	private String ligne5;
	private String latitude;
	private String longitude;
	
	public Ville() {
		
	}
	
	public Ville(String codeCommune, String nomCommune, String codePostal, String libelle, String latitude,
			String longitude) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelle = libelle;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Ville(String codeCommune, String nomCommune, String codePostal, String libelle, String ligne5, String latitude,
			String longitude) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelle = libelle;
		this.ligne5 = ligne5;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

}
