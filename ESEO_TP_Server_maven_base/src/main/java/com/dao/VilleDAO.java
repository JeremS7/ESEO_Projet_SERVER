package com.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> getAllCities();
	
	public ArrayList<Ville> getCityByCodePost(String codeCommune);

}
