
package dni;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.BeforeClass;

public class TablaAsignacionTest {

    private static TablaAsignacion tabla;
    private static final char[] letrasNoPermitidas = {'I', 'Ñ', 'O', 'U'};

    @BeforeClass
    public static void crearTabla() {
        tabla = new TablaAsignacion();
    }

    @Test 
    public void getLetraTablaAsignacion() {
		assertEquals('T', tabla.getLetra(0));
		assertEquals('E' , tabla.getLetra(22));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getLetraFueraLimitesTablaAsignacion() {
        tabla.getLetra(100);
    }

    @Test
    public void letraNoPermitida() {
        
        for (char letra : letrasNoPermitidas) {
            assertFalse(tabla.letraPermitida(letra));
        }
    }

    private static boolean testCalcularLetra(List<String> casosTest, TablaAsignacion tabla){
		 
        for (String dni : casosTest) {
            
            String parteNumericaDni = dni.substring(0, dni.length() - 1);
            char letraDni = dni.charAt(dni.length() - 1);
            
            if (tabla.calcularLetra( parteNumericaDni ) == letraDni) {
                continue;
            } else {
                return false;
            }
        }
        return true;
 }


    @Test
    public void calcularLetraPermitida() {

        String[] casosTest = { //casos OK
        "78484464T","72376173A","01817200Q","95882054E","63587725Q",
        "26861694V","21616083Q","26868974Y","40135330P","89044648X",
        "80117501Z","34168723S","76857238R","66714505S","66499420A"};

        assertTrue(testCalcularLetra(List.of(casosTest), tabla));
    }

    @Test
    public void calcularLetraNoPermitida() {
			
			int numeroCasos = 15;
            StringBuilder caso = null;
			
			List<String> casosTestKO = new ArrayList<>();
			
			for(int i = 1; i <= numeroCasos; i++) {
                caso = new StringBuilder("");
                // Genero un string de 8 dígitos entre 0 y 9 = dni
				for(int j = 1; j < 9; j++){
                    // Genero un entero entre 48 y 57 = código ASCII de los números 0 al 9 y caracter :
					Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 58); // 58 excluido
                    // convierto el entero a un string de chars y luego lo convierto en un String
                    caso.append(String.valueOf(Character.toChars(caracterAscii)));
                }
                // Extraigo al azar una letra del array de strings de letras no permitidas
				// y la añado (concateno) al string dni
                caso.append(letrasNoPermitidas[ThreadLocalRandom.current().nextInt(0, 4)]);
                // inicializo el array con los casos test FAIL en la posición adecuada
                casosTestKO.add(caso.toString());
            }
            
            assertFalse(testCalcularLetra(casosTestKO, tabla));

			// for in range == Python	
			// import java.util.stream.*;
			// Stream<Integer> rango = IntStream.range(0, 10).boxed();
			//IntStream.range(0, 10).forEach( i -> crearCaso() );  
    }
}