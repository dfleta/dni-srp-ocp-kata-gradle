package dni;

import java.io.IOException;

public class DniCif {
	
		private String dni  = null;
		private Boolean numeroSano = false;
		private Boolean letraSana 	= false;
		private Boolean dniCifSano  = false;
		// Composición (agregación) "Has - a" / "Tiene - un"
		private TablaAsignacion tabla = new TablaAsignacion();

		/* Constructores */
		
		public DniCif(String dni) {
			this.dni = dni;
		}
		
		/* Encapsulacion */
		
		public void setDni(String cadena){
			this.dni = cadena;
		}

		public String getDni(){
			return this.dni;
		}
	
		private void setNumeroSano(Boolean valor){
			this.numeroSano = valor;
		}
		
		public Boolean getNumeroSano(){
			return this.numeroSano;
		}
		
		private void setLetraSana(Boolean valor){
			this.letraSana = valor;
		}
	
		public Boolean getLetraSana(){
			return this.letraSana;
		}
		
		public void setDniCifSano(Boolean valor){
			this.dniCifSano = valor;
		}
		
		public Boolean getDniCifSano(){
			return this.dniCifSano;
		}
		/*
		 * Lógica 
		 */
	
		/* Interfaz Pública */
		
		public Boolean checkCIF(){
			setDniCifSano( checkDni() && checkLetra() );
			return getDniCifSano();
		}
		
		public Boolean checkDni(){
			setNumeroSano( checkLongitud() && stringEsNumero( getParteNumericaDni() ) );
			return getNumeroSano();
		}
		
		public Boolean checkLetra(){
			if (getNumeroSano() ) {
				setLetraSana ( Character.isUpperCase(getParteAlfabeticaDni()) && checkLetraValida() );
				return getLetraSana();
			}
			else {
				return false;
			}
		}
						
		public Character obtenerLetra() throws IOException{
			// calcularLetra no puede ejecutarse si antes no se cumplen las condiciones previas en checkDni
			// y checkletra
			if ( getNumeroSano() ){
				return this.tabla.calcularLetra( getParteNumericaDni() );
			}
			else // EXCEPCION: aun no sabemos implementarlas - este código no es admisible
				throw new IOException("Parte numérica del DNI no está sana");
		}
	
	
		public Boolean checkLongitud() {
			return getDni().length() == 9;
		}
		
		public Boolean stringEsNumero(String cadena){
			for( int i=0; i < cadena.length(); i++ ){
				if ( ! Character.isDigit(cadena.charAt(i)) ){
					return false;
				}
				else;
			}
			return true;
		}		
			
		public String getParteNumericaDni() {
			return (String) dni.substring(0, dni.length() - 1);
		}
		
		public Character getParteAlfabeticaDni() {
			return dni.charAt(dni.length() - 1);
		}
		
		public Boolean checkLetraValida() {
			try {
				return getParteAlfabeticaDni() == obtenerLetra();
			}
			catch(IOException ioexcepcion){
				return false;
			}
				
		}

}
