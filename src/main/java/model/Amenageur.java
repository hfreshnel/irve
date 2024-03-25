package model;

public class Amenageur {
	private String nom;
	private String siren;
	private String contact;
	
	public Amenageur(String nom, String siren, String contact) {
		this.nom = nom;
		this.siren = siren;
		this.contact = contact;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Amenageur [nom=" + nom + ", siren=" + siren + ", contact=" + contact + "]";
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSiren() {
		return siren;
	}

	public void setSiren(String siren) {
		this.siren = siren;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
