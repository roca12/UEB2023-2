package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.controller.AplMain;

public class AplMainTest {
	
	static int numPrueba=1;
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println("Iniciando las pruebas unitarias de AplMain");
	}
	
	@Before
	public void beforeEachOne() {
		System.out.println("Iniciando prueba unitaria "+numPrueba);
	}
	
	@AfterClass
	public static void afterAll() {
		System.out.println("Finalizando las pruebas unitarias de AplMain");
	}
	
	@After
	public void afterEachOne() {
		System.out.println("Finalizando prueba unitaria "+numPrueba);
		numPrueba++;
	}

	@Test
	public void probarSuma1() {
		double nums[] = { 4, 5, 6, 7, 8 };
		double resEsperado = 0;
		for (double i : nums) {
			resEsperado += i;
		}
		System.out.println("resultado esperado: "+resEsperado);
		
		double resObtenido=AplMain.sumar(4,5,6,7,8);
		System.out.println("resultado obtenido: "+resEsperado);
		assertTrue(resEsperado==resObtenido);
	}
	
	@Test
	public void probarSuma2() {
		double nums[] = { 4, 5, 6, 7, 8 ,8};
		double resEsperado = 0;
		for (double i : nums) {
			resEsperado += i;
		}
		System.out.println("resultado esperado: "+resEsperado);
		
		double resObtenido=AplMain.sumar(4,5,6,7,8);
		System.out.println("resultado obtenido: "+resEsperado);
		assertTrue(resEsperado==resObtenido);
	}

}
