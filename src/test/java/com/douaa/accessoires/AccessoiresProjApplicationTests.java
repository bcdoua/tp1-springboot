package com.douaa.accessoires;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.douaa.accessoires.entities.Accessoire;
import com.douaa.accessoires.repos.AccessoireRepository;
import com.douaa.accessoires.service.AccessoireService;

@SpringBootTest
class AccessoiresProjApplicationTests {

	@Autowired
	private AccessoireRepository accessoireRepository;
	@Autowired
	private AccessoireService  accessoireService;
	@Test
	public void testCreateAccessoire() {
		Accessoire acc = new Accessoire("Collier",4000.500,new Date());
		accessoireRepository.save(acc);
	}
	@Test
	public void testFindAccessoire()
	{
		Accessoire a = accessoireRepository.findById(1L).get();
	System.out.println(a);
	}
	@Test
	public void testUpdateAccessoire() {
	    Accessoire a = accessoireRepository.findById(1L).get();
	    a.setTarif(2000.0);
	    accessoireRepository.save(a);
	    System.out.println(a);
	}
	public void testDeleteAccessoire()
	{
		accessoireRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousAccessoires()
	{
	List<Accessoire> accs = accessoireRepository.findAll();
	for (Accessoire a : accs)
	{
	System.out.println(a);
	}
	}
	
	@Test 
	public void testFindByNomProduitContains() 
	{ 
	Page<Accessoire>  accs = accessoireService.getAllAccessoiresParPage(0,2); 
	System.out.println(accs.getSize()); 
	System.out.println(accs.getTotalElements()); 
	System.out.println(accs.getTotalPages()); 
	
	accs.getContent().forEach(a -> {System.out.println(a.toString()); 
	});  
	/*ou bien 
	for (Accessoire a : accs)
	{ 
	System.out.println(a); 
	} */
	}

	




}
