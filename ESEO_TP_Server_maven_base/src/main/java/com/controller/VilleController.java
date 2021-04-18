package com.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.JDBCConfiguration;
import com.dao.VilleDAOImpl;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	// @Autowired
	// VilleBLO villeService;

	// Methode GET
	@CrossOrigin
	@RequestMapping(value = "/listeVille", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet() {
		JDBCConfiguration jdbc = new JDBCConfiguration();
		VilleDAOImpl villeDao = new VilleDAOImpl(jdbc);
		return villeDao.getAllCities();
	}
	
	//Retourne un objet de type ville en fonction du codeCommune
	@CrossOrigin
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public Ville getVilleByCode(@RequestParam String codeCommune) {
		JDBCConfiguration jdbc = new JDBCConfiguration();
		VilleDAOImpl villeDao = new VilleDAOImpl(jdbc);
		return villeDao.getCityByCodePost(codeCommune);
	}
	
	//Met à jour les données d'une ville
	@CrossOrigin
	@RequestMapping(value = "/villeUpdate", method = RequestMethod.PUT)
	@ResponseBody
	public void UpdateCity(@RequestBody Ville ville) {
		JDBCConfiguration jdbc = new JDBCConfiguration();
		VilleDAOImpl villeDao = new VilleDAOImpl(jdbc);
		villeDao.updateCity(ville);
	}
	
	//Ajoute une nouvelle ville
	@CrossOrigin
	@RequestMapping(value = "/villeInsert", method = RequestMethod.POST)
	@ResponseBody
	public void addCity(@RequestBody Ville ville) {
		JDBCConfiguration jdbc = new JDBCConfiguration();
		VilleDAOImpl villeDao = new VilleDAOImpl(jdbc);
		villeDao.addCity(ville);
	}
	
	//Supprime une ville en fonction de son code
	@CrossOrigin
	@RequestMapping(value = "/villeDelete", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCity(@RequestParam String codeCommune) {
		JDBCConfiguration jdbc = new JDBCConfiguration();
		VilleDAOImpl villeDao = new VilleDAOImpl(jdbc);
		villeDao.deleteCity(codeCommune);
	}
}
