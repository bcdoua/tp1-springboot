package com.douaa.accessoires.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.douaa.accessoires.entities.Accessoire;

public interface AccessoireService {
	Accessoire saveAccessoire(Accessoire a);
	Accessoire updateAccessoire(Accessoire a);
	void deleteAccessoire(Accessoire a);
	void deleteAccessoireById(Long id);
	Accessoire getAccessoire(Long id);
	List<Accessoire> getAllAccessoires();
	
	Page<Accessoire> getAllAccessoiresParPage(int page, int size); 

}
