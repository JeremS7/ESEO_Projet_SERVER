package com.controller;

import java.util.ArrayList;
import java.util.Optional;

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

	//@Autowired
	//VilleBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam Optional<String> codeCommune) {
		JDBCConfiguration jdbc = new JDBCConfiguration();
		VilleDAOImpl villeDao = new VilleDAOImpl(jdbc);
		
		if ( codeCommune.isPresent()) {
			return villeDao.getCityByCodePost(codeCommune.get());
		}
		else {
			return villeDao.getAllCities();
		}
		
	}
}
