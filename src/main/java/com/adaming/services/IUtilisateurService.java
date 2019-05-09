package com.adaming.services;

import java.util.List;

import com.adaming.entities.Utilisateur;


public interface IUtilisateurService {

	public Utilisateur save(Utilisateur utilisateur);

	public void delete(Long id);

	public List<Utilisateur> findAll();

	public Utilisateur findOne(Long id);// Soit on trouve nul soit on retrouve l'objet recherché

}
