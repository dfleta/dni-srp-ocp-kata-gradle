
package dni;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;

public class TablaAsignacionTest {

    private static TablaAsignacion tabla = null;

    @BeforeClass
    public static void crearTabla() {
        tabla = new TablaAsignacion();

    }
    @Test 
    public void getLetraTablaAsignacion() {
		assertEquals('T', tabla.getLetra(0));
		assertEquals('E' , tabla.getLetra(22));
    }

    @Test
    public void letraNoPermitida() {

        char[] letrasNoPermitidas = {'I', 'Ñ', 'O', 'U'};
        
        for (char letra : letrasNoPermitidas) {
            assertFalse(tabla.letraPermitida(letra));
        }
    }

    // test calcular letra con casos OK - utilizando un array de Strings
    @Test
    public void calcularLetra() {
        String[] casosTest = { //casos OK
        "78484464T","72376173A","01817200Q","95882054E","63587725Q",
        "26861694V","21616083Q","26868974Y","40135330P","89044648X",
        "80117501Z","34168723S","76857238R","66714505S","66499420A"};

        for (String dni : casosTest) {
            String parteNumericaDni = dni.substring(0, dni.length() - 1);
            char letraDni = dni.charAt(dni.length() - 1);

            assertEquals(letraDni, tabla.calcularLetra(parteNumericaDni));           
        }
    }
}