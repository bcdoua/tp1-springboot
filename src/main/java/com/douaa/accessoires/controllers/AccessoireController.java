package com.douaa.accessoires.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.douaa.accessoires.entities.Accessoire;
import com.douaa.accessoires.service.AccessoireService;

@Controller
public class AccessoireController {

	@Autowired
	AccessoireService accessoireService;

	@RequestMapping("/ListeAccessoires")
	public String listeAccessoires(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size", defaultValue = "2") int size)
{
		Page<Accessoire> accs = accessoireService.getAllAccessoiresParPage(page, size); 
		modelMap.addAttribute("accessoires", accs); 
		modelMap.addAttribute("pages", new int[accs.getTotalPages()]);  
		modelMap.addAttribute("currentPage", page);    
		return "listeAccessoires"; 
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createAccessoire";
	}

	@RequestMapping("/saveAccessoire")
	public String saveAccessoire(@ModelAttribute("accessoire") Accessoire accessoire, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {

		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateAjout = dateformat.parse(String.valueOf(date));
		accessoire.setDateAjout(dateAjout);

		Accessoire saveAccessoire = accessoireService.saveAccessoire(accessoire);
		String msg = "accessoire enregistré avec Id " + saveAccessoire.getCodeAcc();
		modelMap.addAttribute("msg", msg);

		return "createAccessoire";
	}

	@RequestMapping("/supprimerAccessoire")
	public String supprimerAccessoire(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size", defaultValue = "3") int size) {

		accessoireService.deleteAccessoireById(id);
		Page<Accessoire> accs = accessoireService.getAllAccessoiresParPage(page, size);
		modelMap.addAttribute("accessoires", accs);   
	    modelMap.addAttribute("pages", new int[accs.getTotalPages()]);  
	    modelMap.addAttribute("currentPage", page);  
	    modelMap.addAttribute("size", size);
		return "listeAccessoires";
	}

	@RequestMapping("/modifierAccessoire")
	public String editerAccessoire(@RequestParam("id") Long id, ModelMap modelMap) {

		Accessoire a = accessoireService.getAccessoire(id);
		modelMap.addAttribute("accessoire", a);

		return "editerAccessoire";
	}

	@RequestMapping("/updateAccessoire")
	public String updateAccessoire(@ModelAttribute("accessoire") Accessoire accessoire,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {

		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateAjout = dateformat.parse(String.valueOf(date));
		accessoire.setDateAjout(dateAjout);

		accessoireService.updateAccessoire(accessoire);
		List<Accessoire> accs = accessoireService.getAllAccessoires();
		modelMap.addAttribute("accessoires", accs);

		return "listeAccessoires";
	}
}