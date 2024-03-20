
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest {
	
	static int numeroPrueba=1;
	static Calculadora c= new Calculadora();
	
	@BeforeClass
	public static void antesDeTodas() {
		System.out.println("iniciando todas las pruebas unitarias de Calculadora \n\n");
	}
	
	@Before
	public void mostrarMensajeAntesPrueba() {
		System.err.println("empezando la siguiente prueba #"+numeroPrueba);
	}
	
	@Test
	public void probarSuma1() {
		System.out.println("iniciando la prueba de suma #1");
		double res= c.sumar(20,3,7,-6,-10,9);
		assertTrue(res==23);
	}
	
	@Test
	public void probarSuma2() {
		System.out.println("iniciando la prueba de suma #2");
		double res= c.sumar(0,0,0,0,0,0,0,0,0,0);
		assertTrue(res==0);
	}
	
	@Test
	public void verificarNombres() {
		System.out.println("iniciando la prueba de verificacion de nombres #1");
		String nombre ="diego";
		assertEquals(nombre, "diego");
	}
	
	
	
	@After
	public void mostrarMensajeLuegoPrueba() {
		System.err.println("Finalizando prueba #"+numeroPrueba+"\n");
		numeroPrueba++;
	}
	
	
	
	@AfterClass
	public static void despuesDeTodas() {
		System.out.println("Finalizando todas las pruebas unitarias de Calculadora \n\n");
	}

}
