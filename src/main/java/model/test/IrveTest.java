package model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

class IrveTest {
    private Irve irve;
    private Operateur operateur;
    private Amenageur amenageur;
    private ArrayList<String> typesDePrise;

    @BeforeEach
    void setUp() {
        typesDePrise = new ArrayList<>(Arrays.asList("Type1", "Type2"));
        operateur = new Operateur("OperateurNom", "OperateurContact", "OperateurTelephone");
        amenageur = new Amenageur("AmenageurNom", "AmenageurSiren", "AmenageurContact");
        irve = new Irve("NomStation", "NomEnseigne", "Implantation", "Adresse", "PuissanceNominale",
                        typesDePrise, "Horaire", "Longitude", "Latitude", "Tarification", 
                        true, operateur, amenageur);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("NomStation", irve.getNom());
        assertEquals("NomEnseigne", irve.getNomEnseigne());
        assertEquals("Implantation", irve.getImplantation());
        assertEquals("Adresse", irve.getAdresse());
        assertEquals("PuissanceNominale", irve.getPuissanceNominale());
        assertEquals(typesDePrise, irve.getTypesDePrise());
        assertEquals("Horaire", irve.getHoraire());
        assertEquals("Longitude", irve.getLongitude());
        assertEquals("Latitude", irve.getLatitude());
        assertEquals("Tarification", irve.getTarification());
        assertTrue(irve.isDeuxRoues());
        assertEquals(operateur, irve.getOperateur());
        assertEquals(amenageur, irve.getAmenageur());
    }

    @Test
    void testToJSON() throws JSONException {
        JSONObject json = irve.toJSON();

        assertEquals("NomStation", json.getString("nom"));
        assertEquals("NomEnseigne", json.getString("nomEnseigne"));
        assertEquals("Implantation", json.getString("implantation"));
        assertEquals("Adresse", json.getString("adresse"));
        assertEquals("PuissanceNominale", json.getString("puissanceNominale"));
        assertEquals("Horaire", json.getString("horaire"));
        assertEquals("Longitude", json.getString("longitude"));
        assertEquals("Latitude", json.getString("latitude"));
        assertEquals("Tarification", json.getString("tarification"));
        assertTrue(json.getBoolean("deuxRoues"));

        JSONArray jsonTypesDePrise = json.getJSONArray("typesDePrise");
        for (int i = 0; i < typesDePrise.size(); i++) {
            assertEquals(typesDePrise.get(i), jsonTypesDePrise.getString(i));
        }

        JSONObject jsonOperateur = json.getJSONObject("operateur");
        assertEquals(operateur.getNom(), jsonOperateur.getString("nom"));

        JSONObject jsonAmenageur = json.getJSONObject("amenageur");
        assertEquals(amenageur.getNom(), jsonAmenageur.getString("nom"));
    }
}
