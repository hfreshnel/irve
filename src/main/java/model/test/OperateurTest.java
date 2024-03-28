package model.test;

import org.junit.jupiter.api.Test;

import model.Operateur;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.json.JSONObject;

public class OperateurTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        String nom = "Operateur1";
        String contact = "operateur1@gmail.com";
        String telephone = "0123456789";
        Operateur operateur = new Operateur(nom, contact, telephone);
        
        // Act and Assert
        assertEquals(nom, operateur.getNom());
        assertEquals(contact, operateur.getContact());
        assertEquals(telephone, operateur.getTelephone());
        
        // Update values
        String misajourNom = "NewOperateur1";
        String misajourContact = "misajournewoperateur1@gmail.com";
        String misajourTelephone = "0987654321";
        
        operateur.setNom(misajourNom);
        operateur.setContact(misajourContact);
        operateur.setTelephone(misajourTelephone);
        
        // Assert misajour values
        assertEquals(misajourNom, operateur.getNom());
        assertEquals(misajourContact, operateur.getContact());
        assertEquals(misajourTelephone, operateur.getTelephone());
    }

    @Test
    public void testToJSON() throws JSONException {
        // Arrange
        String nom = "UnNom";
        String contact = "test@gmail.com";
        String telephone = "0123456789";
        Operateur operateur = new Operateur(nom, contact, telephone);
        
        // Act
        JSONObject jsonObject = operateur.toJSON();
        
        // Assert
        assertEquals(nom, jsonObject.getString("nom"));
        assertEquals(contact, jsonObject.getString("contact"));
        assertEquals(telephone, jsonObject.getString("telephone"));
    }
}
