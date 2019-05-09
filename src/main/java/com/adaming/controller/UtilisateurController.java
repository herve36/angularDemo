package com.adaming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.adaming.entities.Utilisateur;
import com.adaming.services.IUtilisateurService;

@CrossOrigin("*")
@RestController // indiquer que l'on va utiliser les verbes http/delete/post
public class UtilisateurController {

	@Autowired
	IUtilisateurService utilisateurService;

	@RequestMapping(value = "users", method = RequestMethod.GET) // la méthode expose son web service (pour utiliser les
																	// url) à l'application
	public List<Utilisateur> findAll(HttpServletRequest request) {
		return utilisateurService.findAll();
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id") Long id) {
		return utilisateurService.findOne(id);
	}

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {// requete envoyée à la base avec le body
		return utilisateurService.save(utilisateur);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		utilisateurService.delete(id);
	}
	
	@RequestMapping(value="users/{id}", method= RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUser=utilisateurService.findOne(id);
		currentUser.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUser.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		return utilisateurService.save(currentUser);
		
	}
	
	
	
	
	

}
