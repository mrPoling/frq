import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExperimentalFarmTest {
    private static ExperimentalFarm farm;
    private static Plot[][] fp;

    @BeforeEach
    void setUp() {

        //Test expectations are based on this specific matrix of Plots 
        // (which differs very slightly from original FRQ)
        Plot[][] temp = {
                    {new Plot("corn", 20), new Plot("corn", 30), new Plot("peas", 10)},
                    {new Plot("peas", 25), new Plot("corn", 40), new Plot("corn", 62)},
                    {new Plot("wheat",10), new Plot("corn", 50), new Plot("rice", 30)},
                    {new Plot("corn", 55), new Plot("corn", 30), new Plot("peas", 30)}
                };
        fp = temp;
        farm = new ExperimentalFarm(fp);
    }

    @Test
    @DisplayName("Check if 'corn' yields farmPlots[1][2]")
    void testGetHighestYield_Corn() {
        Plot expected = fp[1][2];
        Plot actual = farm.getHighestYield("corn");

        String failMessage = "Incorrect Plot. Expected: " 
            + expected.getCropType() + "|" + expected.getCropYield() 
            + "  Actual: " + actual.getCropType() + "|" + actual.getCropYield() + "\n";

        assertEquals(expected, actual, failMessage);
    }

    @Test
    @DisplayName("Check if 'peas' yields farmPlots[3][2]")
    void testGetHighestYield_Peas() {
        Plot expected = fp[3][2];
        Plot actual = farm.getHighestYield("peas");

        String failMessage = "Incorrect Plot. Expected: " 
            + expected.getCropType() + "|" + expected.getCropYield() 
            + "  Actual: " + actual.getCropType() + "|" + actual.getCropYield() + "\n";

        assertEquals(expected, actual, failMessage);
    }

    @Test
    @DisplayName("Check if 'bananas' yields null")
    void testGetHighestYield_NonExistent_Crop() {
        Plot actual = farm.getHighestYield("bananas");
        assertNull(actual);
    }

    @Test
    @DisplayName("Check if column with all same crop yields true")
    void testSameCrop_allSame() {
        int columnWithAllCorn = 1;
        assertTrue(farm.sameCrop(columnWithAllCorn));
    }

    @Test
    @DisplayName("Check if mixed-crops column yields false")
    void testSameCrop_Mixed_Column0() {
        String failMessage = "Expected: false  Actual: true ";
        assertFalse(failMessage, farm.sameCrop(0));
    }

    @Test
    @DisplayName("Check if 2nd mixed-crops column yields false")
    void testSameCrop_Mixed_Column2() {
        String failMessage = "Expected: false  Actual: true ";
        assertFalse(failMessage, farm.sameCrop(2));
    }

    
}
