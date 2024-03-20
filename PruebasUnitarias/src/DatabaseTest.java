import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseTest {
	
	static Database d;
	static int numeroPrueba=1;
	
	@BeforeClass
	public static void iniciarTesting() {
		d= new Database();
		d.setProyectoFacil(true);
		int[] primos= {2,3,5,7,11,13,17,19,23,29};
		d.setPrimos(primos);
		d.getNumeros().add(7);
		d.getNumeros().add(12);
		d.getNumeros().add(14);
		d.getNumeros().add(15);
		d.getNumeros().add(11);
		System.out.println("datos iniciales cargados, iniciando testing de Database\n");
	}
	
	@Before
	public void antesDeCadaPrueba() {
		System.err.println("iniciando la prueba "+numeroPrueba);
	}
	
	@Test
	public void comparePrimos() {

		
	}
	

	

}
