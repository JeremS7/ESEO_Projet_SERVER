package com.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> getAllCities();
	
	public Ville getCityByCodePost(String codeCommune);
	
	public void updateCity(Ville ville);
	
	public void addCity(Ville ville);
	
	public void deleteCity(String codeCommune);

}
