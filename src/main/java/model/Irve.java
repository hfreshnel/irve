package model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Irve {
	
	private String nom;
	private String nomEnseigne;
	private String implantation;
	private String adresse;
	private String puissanceNominale;
	private ArrayList<String> typesDePrise = new ArrayList<String>();
	private String horaire;
	private String longitude;
	private String latitude;
	private String tarification;
	private boolean deuxRoues;
	private Operateur operateur;
	private Amenageur amenageur;
	
	public Irve(String nom, String nomEnseigne, String implantation, String adresse, String puissanceNominale,
			ArrayList<String> typesDePrise, String horaire, String longitude, String latitude, String tarification, boolean deuxRoues, Operateur operateur,
			Amenageur amenageur) {
		this.nom = nom;
		this.nomEnseigne = nomEnseigne;
		this.implantation = implantation;
		this.adresse = adresse;
		this.puissanceNominale = puissanceNominale;
		this.typesDePrise = typesDePrise;
		this.horaire = horaire;
		this.longitude = longitude;
		this.latitude = latitude;
		this.tarification =tarification;
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
	
	/**
	 * @return the typesDePrise
	 */
	public ArrayList<String> getTypesDePrise() {
		return typesDePrise;
	}
	/**
	 * @param typesDePrise the typesDePrise to set
	 */
	public void setTypesDePrise(ArrayList<String> typesDePrise) {
		this.typesDePrise = typesDePrise;
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
	public String getTarification() {
		return tarification;
	}
	public void setTarification(String tarification) {
		this.tarification = tarification;
	}
	@Override
	public String toString() {
		return "Irve [nom=" + nom + ", nomEnseigne=" + nomEnseigne + ", implantation=" + implantation + ", adresse="
				+ adresse + ", puissanceNominale=" + puissanceNominale + ", typesDePrise=" + typesDePrise + ", horaire="
				+ horaire + ", longitude=" + longitude + ", latitude=" + latitude + ", tarification=" + tarification
				+ ", deuxRoues=" + deuxRoues + ", operateur=" + operateur + ", amenageur=" + amenageur + "]";
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
			jsonObject.put("nom", this.nom);
			jsonObject.put("nomEnseigne", this.nomEnseigne);
	        jsonObject.put("implantation", this.implantation);
	        jsonObject.put("adresse", this.adresse);
	        jsonObject.put("puissanceNominale", this.puissanceNominale);
	        // Convertir l'ArrayList typesDePrise en JSONArray
	        JSONArray typesDePriseArray = new JSONArray(this.typesDePrise);
	        jsonObject.put("typesDePrise", typesDePriseArray);
	        jsonObject.put("horaire", this.horaire);
	        jsonObject.put("longitude", this.longitude);
	        jsonObject.put("latitude", this.latitude);
	        jsonObject.put("tarification", this.tarification);
	        jsonObject.put("deuxRoues", this.deuxRoues);
	        // Convertir l'objet operateur en JSONObject
	        if (this.operateur != null) {
	            jsonObject.put("operateur", this.operateur.toJSON());
	        }
	        // Convertir l'objet amenageur en JSONObject
	        if (this.amenageur != null) {
	            jsonObject.put("amenageur", this.amenageur.toJSON());
	        }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return jsonObject;
    }
}
