package dni;
	
public class Dni {
	
	private final String dni;
	private Boolean numeroSano = false;
	private Boolean letraSana = false;
	private Boolean dniCifSano = false;
	private final byte LONGITUD_DNI = 9;
	// "Has - a" / "Tiene - una"
	private TablaAsignacion tabla = new TablaAsignacion();

	public Dni(String dni) {
		this.dni = dni;
	}

	/**
	 * Encapsulacion & Information hiding
	 */

	private String getDni() {
		return this.dni;
	}

	private void setNumeroSano(Boolean valor) {
		this.numeroSano = valor;
	}

	private Boolean isNumeroSano() {
		return this.numeroSano;
	}

	private void setLetraSana(Boolean valor) {
		this.letraSana = valor;
	}

	private Boolean isLetraSana() {
		return this.letraSana;
	}

	private void setDniSano(Boolean valor) {
		this.dniCifSano = valor;
	}

	private Boolean isDniSano() {
		return this.dniCifSano;
	}
	
	private TablaAsignacion getTablaAsignacion(){
		return this.tabla;
	}

	/**
	 * Interfaz Pública
	 */

	@Override
	public String toString() {
		return getDni();
	}

	public Boolean checkDni() {
		setDniSano(checkNumeroDni() && checkLetra());
		return isDniSano();
	}

	public Boolean checkNumeroDni() {
		setNumeroSano(checkLongitudDni() 
						&& isDniNumero(extraerParteNumericaDni()));
		return isNumeroSano();
	}

	public Boolean checkLetra() {
		checkNumeroDni();
		if (isNumeroSano()) {
			setLetraSana(Character.isUpperCase(extraerParteAlfabeticaDni()) 
							&& checkLetraValida());
			return isLetraSana();
		} else {
			return false;
		}
	}

	public Character obtenerLetra() {
		// calcularLetra no puede ejecutarse si antes
		// no se cumplen las condiciones previas en
		// checkDni y checkLetra
		checkNumeroDni();
		if (isNumeroSano()) {
			return getTablaAsignacion().calcularLetra(extraerParteNumericaDni());
		} else {
			// si el DNI no esta bien formado
			return Character.MIN_VALUE;
		}
	}

	/**
	 * Implementacion 
	 */

	private Boolean checkLongitudDni() {
		return getDni().length() == this.LONGITUD_DNI;
	}

	Boolean isDniNumero(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			} else
				;
		}
		return true;
	}

	String extraerParteNumericaDni() {
		return (String) dni.substring(0, dni.length() - 1);
	}

	Character extraerParteAlfabeticaDni() {
		return dni.charAt(dni.length() - 1);
	}

	private Boolean checkLetraValida() {
		return extraerParteAlfabeticaDni() == obtenerLetra();
	}
}
