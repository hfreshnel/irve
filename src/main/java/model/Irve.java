package model;

import java.util.ArrayList;

public class Irve {
	
	private String nom;
	private String nomEnseigne;
	private String implantation;
	private String adresse;
	private String puissanceNominale;
	private ArrayList<String> typesDePrise = new ArrayList<String>();
	private String horaire;
	private boolean deuxRoues;
	private Operateur operateur;
	private Amenageur amenageur;
	
	public Irve(String nom, String nomEnseigne, String implantation, String adresse, String puissanceNominale,
			ArrayList<String> typesDePrise, String horaire, boolean deuxRoues, Operateur operateur,
			Amenageur amenageur) {
		this.nom = nom;
		this.nomEnseigne = nomEnseigne;
		this.implantation = implantation;
		this.adresse = adresse;
		this.puissanceNominale = puissanceNominale;
		this.typesDePrise = typesDePrise;
		this.horaire = horaire;
		this.deuxRoues = deuxRoues;
		this.operateur = operateur;
		this.amenageur = amenageur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the operateur
	 */
	public Operateur getOperateur() {
		return operateur;
	}
	/**
	 * @param operateur the operateur to set
	 */
	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}
	/**
	 * @return the amenageur
	 */
	public Amenageur getAmenageur() {
		return amenageur;
	}
	/**
	 * @param amenageur the amenageur to set
	 */
	public void setAmenageur(Amenageur amenageur) {
		this.amenageur = amenageur;
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
		return typesDePrise;
	}
	public void setTypesdePrise(ArrayList<String> typesdePrise) {
		typesdePrise = typesdePrise;
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
