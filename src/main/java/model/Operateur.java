package model;

public class Operateur {
	
	private String nom;
	private String contact;
	private String telephone;
	
	public Operateur(String nom, String contact, String telephone) {
		this.nom = nom;
		this.contact = contact;
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
	

}
