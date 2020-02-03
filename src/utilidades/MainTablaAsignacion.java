package utilidades;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import dni.TablaAsignacion;

public class MainTablaAsignacion {

	public static void main(String[] args) {

			TablaAsignacion tabla = new TablaAsignacion();
			
			/* test getLetra */
			System.out.println(tabla.getLetra(0));
			System.out.println(tabla.getLetra(22));
			
			/* test letraPermitida() */
			
			char[] letrasNoPermitidas = {'I', 'Ñ', 'O', 'U'};
			
			for ( char letra : letrasNoPermitidas) {
						System.out.println("Letra " + letra + ": " + tabla.letraPermitida(letra) ) ;
			}
			
			// test calcular letra con casos OK - utilizando un array de Strings
			
			String[] casosTest = { //casos OK
							 		"78484464T","72376173A","01817200Q","95882054E","63587725Q",
							 		"26861694V","21616083Q","26868974Y","40135330P","89044648X",
							 		"80117501Z","34168723S","76857238R","66714505S","66499420A"};
			
			for ( String dni : casosTest ){
				
				String parteNumericaDni = dni.substring(0, dni.length() - 1);
				char letraDni 			= dni.charAt(dni.length() - 1);
				
				if ( tabla.calcularLetra( parteNumericaDni ) == letraDni ) {
					System.out.println( parteNumericaDni + letraDni + " PASS" );
				}
				else System.out.println( parteNumericaDni + letraDni + " FAIL" );
			}
			
			// test casos FAIL - utilizando ArrayList de Strings
			
			int numeroCasos = 15;
			String caso;
			
			ArrayList<String> casosTestKO = new ArrayList<>();
			
			for(int i = 1; i <= numeroCasos; i++){
				caso = "";
				for(int j = 1; j < 9; j++){
					Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 58); // 58 excluido
					caso = caso + String.valueOf( Character.toChars(caracterAscii) );
				}
				caso = caso + letrasNoPermitidas[ ThreadLocalRandom.current().nextInt(0, 4) ];
				casosTestKO.add(caso);
			}
			
			for ( String casoKO : casosTestKO ){
				System.out.println(casoKO);
			}
			
			for(String dni : casosTestKO){
				String parteNumericaDni = dni.substring(0, dni.length() - 1);
				char letraDni 			= dni.charAt(dni.length() - 1);
				if ( tabla.calcularLetra( parteNumericaDni ) == letraDni ) {
					System.out.println( parteNumericaDni + letraDni + " PASS" );
				}
				else System.out.println( parteNumericaDni + letraDni + " FAIL" );				
			}
			// for in range == Python	
			// import java.util.stream.*;
			// Stream<Integer> rango = IntStream.range(0, 10).boxed();
			//IntStream.range(0, 10).forEach( i -> crearCaso() );		
		}

}
