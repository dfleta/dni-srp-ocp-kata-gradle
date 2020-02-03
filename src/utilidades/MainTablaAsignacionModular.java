package utilidades;

import java.util.concurrent.ThreadLocalRandom;

import dni.TablaAsignacion;

public class MainTablaAsignacionModular {

	public static void main(String[] args) {

			TablaAsignacion tabla = new TablaAsignacion();
			
			System.out.println(tabla.getLetra(0));
			System.out.println(tabla.getLetra(22));
			
			/* test letraPermitida() */
			
			char[] letrasNoPermitidas = {'I', 'Ñ', 'O', 'U'};
			
			for ( char letra : letrasNoPermitidas) {
						System.out.println("Letra " + letra + ": " + tabla.letraPermitida(letra) ) ;
			}
			
			/* test calcularLetra() con casos OK */
			
			String[] casosTestOK = { //casos OK
							 		"78484464T","72376173A","01817200Q","95882054E","63587725Q",
							 		"26861694V","21616083Q","26868974Y","40135330P","89044648X",
							 		"80117501Z","34168723S","76857238R","66714505S","66499420A"};
						
			testCalcularLetra(casosTestOK, tabla);
			
			/* test calcularLetra() con casos FAIL */
			
			int numeroCasos = 15;
			String caso;
			
			// generar casos test FAIL
			String[] casosTestKO = new String[numeroCasos];
			
			for(int i = 0; i <= numeroCasos-1; i++){
				caso = "";
				// genero un string de 8 dígitos entre 0 y 9 = dni
				for(int j = 1; j < 9; j++){
					// genero un entero entre 48 y 57 = código ASCII de los números 0 al 9 y caracter :
					Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 58); // 58 excluido
					// convierto el entero a un string de chars y luego lo convierto en un String
					caso = caso + String.valueOf( Character.toChars(caracterAscii) );
				}
				// extraigo al azar una letra del array de strings de letras no permitidas
				// y lo añado (concateno) al string dni
				caso = caso + letrasNoPermitidas[ ThreadLocalRandom.current().nextInt(0, 4) ];
				// inicializo el array con los casos test FAIL en la posición adecuada
				casosTestKO[i] = caso;
			}
			
			// Visualizar los casos test FAIL
			for ( String casoKO : casosTestKO ){
				System.out.println(casoKO);
			}
			
			testCalcularLetra(casosTestKO, tabla);
				
			// for in range == Python	
			// import java.util.stream.*;
			// Stream<Integer> rango = IntStream.range(0, 10).boxed();
			//IntStream.range(0, 10).forEach( i -> crearCaso() );		
		}
	
	 // test de calcularletra()
	 public static void testCalcularLetra( String[] casosTest, TablaAsignacion tabla ){
		 
			for(String dni : casosTest){
				
				String parteNumericaDni = dni.substring(0, dni.length() - 1);
				char letraDni 			= dni.charAt(dni.length() - 1);
				
				if ( tabla.calcularLetra( parteNumericaDni ) == letraDni ) {
					System.out.println( parteNumericaDni + letraDni + " PASS" );
				}
				else 
					System.out.println( parteNumericaDni + letraDni + " FAIL" );	
				
			}
	 }


}
