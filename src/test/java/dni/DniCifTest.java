package dni;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.BeforeClass;

public class DniCifTest {

    private static final String[] casosTestPass = { //casos OK
        "78484464T","72376173A","01817200Q","95882054E","63587725Q",
        "26861694V","21616083Q","26868974Y","40135330P","89044648X",
        "80117501Z","34168723S","76857238R","66714505S","66499420A"};


    @Test
    public void checkDni() {
        DniCif objetoDniCif = null;
        for(String dni : casosTestPass){
            objetoDniCif = new DniCif(dni);
                assertTrue(objetoDniCif.checkDni());
        }    
    }

    @Test
    public void checkLetra() {
        DniCif objetoDniCif = null;
        for(String dni : casosTestPass){
            objetoDniCif = new DniCif(dni);
            objetoDniCif.checkDni();  
            assertTrue(objetoDniCif.checkLetra());
        }
    }

    @Test
    public void checkCIF() {
        DniCif objetoDniCif = null;
        for(String dni : casosTestPass){
            objetoDniCif = new DniCif(dni);   
            assertTrue(objetoDniCif.checkCIF());
        }
    }
}