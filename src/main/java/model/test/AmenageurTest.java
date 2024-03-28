package model.test;

import org.junit.jupiter.api.Test;

import model.Amenageur;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.json.JSONObject;

public class AmenageurTest {

    @Test
    public void testToJSON() throws JSONException {
        // Arrange
        String nom = "Wilfried";
        String siren = "123456789";
        String contact = "test@example.com";
        Amenageur amenageur = new Amenageur(nom, siren, contact);
        
        // Act
        JSONObject jsonObject = amenageur.toJSON();
        
        // Assert
        assertEquals(nom, jsonObject.getString("nom"));
        assertEquals(siren, jsonObject.getString("siren"));
        assertEquals(contact, jsonObject.getString("contact"));
    }
    
    @Test
    public void testGettersAndSetters() {
        // Arrange
        String initialNom = "Initial Nom";
        String initialSiren = "Initial Siren";
        String initialContact = "Initial Contact";
        Amenageur amenageur = new Amenageur(initialNom, initialSiren, initialContact);
        
        String updatedNom = "Updated Nom";
        String updatedSiren = "Updated Siren";
        String updatedContact = "Updated Contact";
        
        // Act - Test des setters
        amenageur.setNom(updatedNom);
        amenageur.setSiren(updatedSiren);
        amenageur.setContact(updatedContact);
        
        // Assert - Test des getters
        assertEquals(updatedNom, amenageur.getNom());
        assertEquals(updatedSiren, amenageur.getSiren());
        assertEquals(updatedContact, amenageur.getContact());
    }
}
