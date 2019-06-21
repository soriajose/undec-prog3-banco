package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import dominio.Cliente;
import excepciones.ExceptionMenorEdad;
import excepciones.ExceptionNulo;
import interfaz.IDateTime;
import mockito.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestCliente {
	
	@Mock
	IDateTime miInterfazTiempo;
	
	@Test
	public void factoryCliente_atributosCliente_instanciaCliente() throws ExceptionNulo, ExceptionMenorEdad {
			
		Mockito.when(miInterfazTiempo.getFecha()).thenReturn(LocalDate.of(2019, 1, 1));
		LocalDate fechaNacimiento = LocalDate.of(1996, 8, 16);
	
		Cliente miCliente = Cliente.factoryCliente("Soria", "Jose", "39300672", fechaNacimiento, miInterfazTiempo);
		assertNotNull(miCliente);

		Cliente miCliente2 = Cliente.factoryCliente("Perez", "Juan", "25432123", fechaNacimiento, miInterfazTiempo);
		assertNotNull(miCliente2);

		Cliente miCliente3 = Cliente.factoryCliente("Lopez", "Ricardo", "28241634", fechaNacimiento, miInterfazTiempo);
		assertNotNull(miCliente3);

	}

	
	@Test
	void factoryCliente_atributosCliente_instanciaIncorrecta() throws ExceptionNulo, ExceptionMenorEdad{
		
		LocalDate fechaNacimiento = LocalDate.of(1996, 8, 16);
		Mockito.when(miInterfazTiempo.getFecha()).thenReturn(LocalDate.of(2019, 1, 1));
			
		Assertions.assertThrows(ExceptionNulo.class, ()-> Cliente.factoryCliente(null, "Jose", "39300672", fechaNacimiento, miInterfazTiempo));
		
		Assertions.assertThrows(ExceptionNulo.class, ()-> Cliente.factoryCliente("Soria", null, "39300672", fechaNacimiento, miInterfazTiempo));

		Assertions.assertThrows(ExceptionNulo.class, ()-> Cliente.factoryCliente("Soria", "Jose", null , fechaNacimiento, miInterfazTiempo));

	}

	
	@Test
	void factoryCliente_atributosFechaMenorDeEdad_instanciaIncorrecta() {
		
		Mockito.when(miInterfazTiempo.getFecha()).thenReturn(LocalDate.of(2019, 1, 1));
		LocalDate fechaNacimiento = LocalDate.of(1996, 8, 16);
		
		Assertions.assertThrows(ExceptionMenorEdad.class, ()-> Cliente.factoryCliente("Soria", "Jose", "48300672", fechaNacimiento, miInterfazTiempo));
				
	}

	
	
	
}
