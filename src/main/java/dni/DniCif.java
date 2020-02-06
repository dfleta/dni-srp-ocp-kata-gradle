package dni;
	
public class DniCif {
	
		private String dni  = null;
		private Boolean numeroSano = false;
		private Boolean letraSana = false;
		private Boolean dniCifSano = false;
		private final byte LONGITUD_DNI = 9;
		// "Has - a" / "Tiene - una"
		private TablaAsignacion tabla = new TablaAsignacion();
	
		public DniCif(String dni) {
			this.dni = dni;
		}
		
		/* Encapsulacion */
		
		public void setDni(String cadena) {
			this.dni = cadena;
		}

		public String getDni() {
			return this.dni;
		}
	
		private void setNumeroSano(Boolean valor) {
			this.numeroSano = valor;
		}
		
		public Boolean isNumeroSano() {
			return this.numeroSano;
		}
		
		private void setLetraSana(Boolean valor) {
			this.letraSana = valor;
		}
	
		public Boolean isLetraSana() {
			return this.letraSana;
		}
		
		public void setDniCifSano(Boolean valor) {
			this.dniCifSano = valor;
		}
		
		public Boolean isDniCifSano() {
			return this.dniCifSano;
		}
	
		/* Interfaz Pública */
		
		public Boolean checkCIF() {
			setDniCifSano(checkDni() && checkLetra());
			return isDniCifSano();
		}
		
		public Boolean checkDni() {
			setNumeroSano(checkLongitud() 
							&& isDniNumero(getParteNumericaDni()));
			return isNumeroSano();
		}
		
		public Boolean checkLetra() {
			if (isNumeroSano()) {
				setLetraSana (Character.isUpperCase(getParteAlfabeticaDni()) 
								&& checkLetraValida());
				return isLetraSana();
			}
			else {
				return false;
			}
		}
						
		public Character obtenerLetra() {
			// calcularLetra no puede ejecutarse si antes 
			// no se cumplen las condiciones previas en
			// checkDni y checkLetra
			if (checkDni()) {
				return this.tabla.calcularLetra(getParteNumericaDni());
			} else {
				// si el DNI no esta bien formado
				return Character.MIN_VALUE;
			}
		}
	
	
		public Boolean checkLongitud() {
			return getDni().length() == this.LONGITUD_DNI;
		}
		
		public Boolean isDniNumero(String cadena) {
			for (int i = 0; i < cadena.length(); i++) {
				if (!Character.isDigit(cadena.charAt(i))){
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
			return getParteAlfabeticaDni() == obtenerLetra();				
		}

}
