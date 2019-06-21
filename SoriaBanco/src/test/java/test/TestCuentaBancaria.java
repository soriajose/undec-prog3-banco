package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import dominio.Cliente;

class TestCuentaBancaria {

	@Test
	void factoryCuentaBancaria_atributosCuentaBancaria_instanciaCuentaBancaria() {
		
		
		Cliente miCliente = Cliente.factoryCliente("Soria", "Jose", "39300672", LocalDate.of(1996, 8, 16));
		
		CuentaBancaria miCuentaBancaria = CuentaBancaria.factoryCuentaBancaria(miCliente, LocalDate.of(2019, 6, 18));
		
		
		
	}

}
