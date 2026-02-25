package com.douaa.accessoires;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douaa.accessoires.entities.Accessoire;
import com.douaa.accessoires.service.AccessoireService;

@SpringBootApplication
public class AccessoiresProjApplication   implements CommandLineRunner {
	@Autowired  
	AccessoireService accessoireService; 

	public static void main(String[] args) {
		SpringApplication.run(AccessoiresProjApplication.class, args); 
	}

	@Override
	public void run(String... args) throws Exception {
		accessoireService.saveAccessoire(new Accessoire("Montre", 350.0, new Date())); 
		accessoireService.saveAccessoire(new Accessoire("Sac à main", 220.0, new Date())); 
		accessoireService.saveAccessoire(new Accessoire("Lunettes", 180.0, new Date())); 
		
	}

}
