package model;

import java.util.ArrayList;

public class Irve {
	
	private int id;
	private String nom;
	private String nomEnseigne;
	private String implantation;
	private String adresse;
	private String puissanceNominale;
	private ArrayList<String> TypesdePrise = new ArrayList<String>();
	private String horaire;
	private boolean deuxRoues;
	
	public Irve(int id, String nom, String nomEnseigne, String implantation, String adresse, String puissanceNominale,
			ArrayList<String> typesdePrise, String horaire, boolean deuxRoues) {
		
		this.id = id;
		this.nom = nom;
		this.nomEnseigne = nomEnseigne;
		this.implantation = implantation;
		this.adresse = adresse;
		this.puissanceNominale = puissanceNominale;
		TypesdePrise = typesdePrise;
		this.horaire = horaire;
		this.deuxRoues = deuxRoues;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNomEnseigne() {
		return nomEnseigne;
	}
	public void setNomEnseigne(String nomEnseigne) {
		this.nomEnseigne = nomEnseigne;
	}
	public String getImplantation() {
		return implantation;
	}
	public void setImplantation(String implantation) {
		this.implantation = implantation;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPuissanceNominale() {
		return puissanceNominale;
	}
	public void setPuissanceNominale(String puissanceNominale) {
		this.puissanceNominale = puissanceNominale;
	}
	public ArrayList<String> getTypesdePrise() {
		return TypesdePrise;
	}
	public void setTypesdePrise(ArrayList<String> typesdePrise) {
		TypesdePrise = typesdePrise;
	}
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	public boolean isDeuxRoues() {
		return deuxRoues;
	}
	public void setDeuxRoues(boolean deuxRoues) {
		this.deuxRoues = deuxRoues;
	}
	
	

}
