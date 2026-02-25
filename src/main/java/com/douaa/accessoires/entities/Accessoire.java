package com.douaa.accessoires.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Accessoire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeAcc;
	private String designation;
	private Double tarif;
	private Date dateAjout;
	
	
	public Accessoire() {
		super();
	}
	
	public Accessoire(String designation, Double tarif, Date dateAjout) {
		super();
		this.designation = designation;
		this.tarif = tarif;
		this.dateAjout = dateAjout;
	}

	public Long getCodeAcc() {
		return codeAcc;
	}
	public void setCodeAcc(Long codeAcc) {
		this.codeAcc = codeAcc;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getTarif() {
		return tarif;
	}
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	@Override
	public String toString() {
		return "Accessoires [codeAcc=" + codeAcc + ", designation=" + designation + ", tarif=" + tarif + ", dateAjout="
				+ dateAjout + "]";
	}

	
}
