package utilidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import dni.DniCif;

public class MainDniCif {

	public static void main(String[] args) {
		
		int numeroCasos = 25;
		String caso;
		
		ArrayList<String> casosTest = new ArrayList<>();
		
		for(int i = 1; i <= numeroCasos; i++){
			caso = "";
			for(int j = 1; j < 9; j++){
				Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 59); // 58 excluido
				caso = caso + String.valueOf( Character.toChars(caracterAscii) );
			}
			Integer caracterAscii = ThreadLocalRandom.current().nextInt(65, 91);
			caso = caso + String.valueOf( Character.toChars(caracterAscii) );
			casosTest.add(caso);
		}
		
		System.out.println("\n ***** Casos Test FAIL generados random ***** \n");
		
		for ( String casoTest : casosTest ){
			System.out.println(casoTest);
		}
		
		System.out.println("\n ***** Casos Test FAIL ***** \n");
		
		for(String dni : casosTest){
			DniCif objetoDniCif = new DniCif(dni);
			System.out.print(objetoDniCif.getDni());
			
			if( objetoDniCif.checkCIF() ){
				System.out.println(" PASS");
			}
			else
				System.out.println(" FAIL");
			
			System.out.println("dni --> " + objetoDniCif.getNumeroSano());
			System.out.println("letra --> " + objetoDniCif.getLetraSana());
			try{
				System.out.println("La letra debería ser --> " + objetoDniCif.obtenerLetra());
			}
			catch(IOException ioexcepcion){
				System.out.println("La letra es --> " + objetoDniCif.getParteAlfabeticaDni());
			}
		}
		
		String[] casosTestPass = { //casos OK
		 		"78484464T","72376173A","01817200Q","95882054E","63587725Q",
		 		"26861694V","21616083Q","26868974Y","40135330P","89044648X",
		 		"80117501Z","34168723S","76857238R","66714505S","66499420A"};
		
		System.out.println("\n ***** Casos Test PASS ***** \n");
		
		for(String dni : casosTestPass){
			DniCif objetoDniCif = new DniCif(dni);
			System.out.print(objetoDniCif.getDni());
			
			if( objetoDniCif.checkCIF() ){
				System.out.println(" PASS");
			}
			else
				System.out.println(" FAIL");
			
			System.out.println("dni --> " + objetoDniCif.getNumeroSano());
			System.out.println("letra --> " + objetoDniCif.getLetraSana());
			try{
				System.out.println("La letra debería ser --> " + objetoDniCif.obtenerLetra());
			}
			catch(IOException ioexcepcion){
				System.out.println("La letra es --> " + objetoDniCif.getParteAlfabeticaDni());
			}
		}
		

	}

}
