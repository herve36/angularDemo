package com.adaming.services;

import java.util.List;


import com.adaming.entities.Role;


public interface IRoleService {

	public Role save(Role role);

	public void delete(Long id);

	public List<Role> findAll();

	public Role findOne(Long id);// Soit on trouve nul soit on retrouve l'objet recherché

}
