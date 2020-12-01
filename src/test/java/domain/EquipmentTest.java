package domain;

import org.junit.Assert;
import org.junit.Test;

public class EquipmentTest {

    private final Equipement equipment = new Equipement();

    @Test
    public void testParseNameWhenNameIsVitalite() {
        // Given
        equipment.setName("Vitalité");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Vitalité", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentCritique() {
        // Given
        equipment.setName("2% Critique");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("% Critique", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentResistanceNeutre() {
        // Given
        equipment.setName("2% Résistance Neutre");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("% Résistance Neutre", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentResistanceTerre() {
        // Given
        equipment.setName("2% Résistance Terre");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("% Résistance Terre", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentResistanceFeu() {
        // Given
        equipment.setName("2% Résistance Feu");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("% Résistance Feu", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentResistanceEau() {
        // Given
        equipment.setName("2% Résistance Eau");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("% Résistance Eau", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentResistanceAir() {
        // Given
        equipment.setName("2% Résistance Air");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("% Résistance Air", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsResistanceNeutre() {
        // Given
        equipment.setName("2 Résistance Neutre");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Résistance Neutre", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsResistanceTerre() {
        // Given
        equipment.setName("2 Résistance Terre");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Résistance Terre", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsResistanceFeu() {
        // Given
        equipment.setName("2 Résistance Feu");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Résistance Feu", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsResistanceEau() {
        // Given
        equipment.setName("2 Résistance Eau");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Résistance Eau", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsResistanceAir() {
        // Given
        equipment.setName("2 Résistance Air");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Résistance Air", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentResistanceDistance() {
        // Given
        equipment.setName("2% Résistance distance");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Résistance distance", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentResistanceMelee() {
        // Given
        equipment.setName("2% Résistance mêlée");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Résistance mêlée", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentDommagesDistance() {
        // Given
        equipment.setName("2% Dommages distance");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Dommages distance", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentDommagesMelee() {
        // Given
        equipment.setName("2% Dommages mêlée");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Dommages mêlée", equipment.getName());
    }

    @Test
    public void testParseNameWhenNameIsPercentDommagesAuxSorts() {
        // Given
        equipment.setName("2% Dommages aux sorts");

        // When
        equipment.parseName();

        // Then
        Assert.assertEquals("Dommages aux sorts", equipment.getName());
    }
}