package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Operateur {
	
	@Override
	public String toString() {
		return "Operateur [nom=" + nom + ", contact=" + contact + ", telephone=" + telephone + "]";
	}

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
	
	public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
        	jsonObject.put("nom", this.nom);
            jsonObject.put("contact", this.contact);
			jsonObject.put("telephone", this.telephone);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return jsonObject;
    }
	
	

}
