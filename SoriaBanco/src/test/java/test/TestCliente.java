package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


class TestCliente {

	@Test
	void factoryCliente_atributosCliente_instanciaCliente() {
		
		Cliente miCliente = Cliente.factoryCliente("Soria", "Jose", "39300672", LocalDate.of(1996, 8, 16))
		assertNotNull(miCliente);

		Cliente miCliente2 = Cliente.factoryCliente("Perez", "Juan", "25432123", LocalDate.of(1980, 4, 25))
		assertNotNull(miCliente2);

		Cliente miCliente3 = Cliente.factoryCliente("Lopez", "Ricardo", "28241634", LocalDate.of(1978, 2, 4))
		assertNotNull(miCliente3);

		
	}

}
