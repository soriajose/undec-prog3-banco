package dominio;

import java.time.LocalDate;
import java.util.Date;

import excepciones.ExceptionMenorEdad;
import excepciones.ExceptionNulo;
import interfaz.IDateTime;

public class Cliente {

	private String apellido;
	private String nombre;
	private String DNI;
	private LocalDate fechaNacimiento;
	
	
	private Cliente(String apellido, String nombre, String DNI, LocalDate fechaNacimiento) {
		
		this.apellido = apellido;
		this.nombre = nombre;
		this.DNI = DNI;
		this.fechaNacimiento = fechaNacimiento;
		
	}

	public static Cliente factoryCliente(String apellido, String nombre, String DNI, LocalDate fechaNacimiento, IDateTime miInterfazTiempo) throws ExceptionNulo, ExceptionMenorEdad {
			
		int fecha = (miInterfazTiempo.getFecha().getYear() - fechaNacimiento.getYear());
		
		if(apellido == null || nombre == null || DNI == null || fechaNacimiento == null) {
			
			throw new ExceptionNulo("Atributo del Cliente nulo");
			
		}
			
		if(fecha < 18) {
			
			throw new ExceptionMenorEdad("El cliente es menor de edad");
		}
		
		return new Cliente(apellido, nombre, DNI, fechaNacimiento);
	}

	
	
	
}
