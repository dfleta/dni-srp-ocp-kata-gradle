package dni;

class TablaAsignacion {

	private final char[] tabla = {'T', 'R', 'W', 'A', 'G', 'M', 
					 		'Y', 'F', 'P', 'D', 'X', 'B', 
							'N', 'J', 'Z', 'S', 'Q', 'V', 
							'H', 'L', 'C', 'K', 'E'};

	TablaAsignacion() {};


	// Interfaz

	char calcularLetra(String DNI){

		/* Obtener el numero del dni del string => dni sano
		 * Dividirlo por el número de letras (actualmente 23)
		 * obtener el resto (división módulo)
		 * Consultar TablaAsignacion con ese resto = posicion
		 */
		
		int dni = Integer.parseInt(DNI);
		int posicion = dni % getModulo();
		return getLetra(posicion);
	}

	/*
	 * Implementacion
	 */

	char getLetra(int posicion) throws ArrayIndexOutOfBoundsException { 
		
		/* Code complete:
		 * Manejar las excepciones lo más localmente posible.
		 * Aqui corresponderían aserciones.
		 * La barricada debería estar en el constructor 
		 * de la clase DNI.
		 */

		try {
			return this.tabla[posicion];
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			throw new ArrayIndexOutOfBoundsException(
				"Posicion fuera de los limites de la tabla de asignacion");
		}
	}
	
	private int getModulo() {
		return this.tabla.length;
	}
	
	Boolean isLetraPermitida(char letra) {
		String tablaString = String.valueOf(tabla);
		// contains() requiere una secuencia de caracteres: 
		// convertir el caracter letra a un string
		return tablaString.contains(Character.toString(letra));
	}
}
