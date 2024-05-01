package recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Ejercicio1 {

	static int numeroMultiplos=0;
	static ArrayList<Integer > multiplosDe4= new ArrayList<Integer>();
	public static void main(String[] args) {
		System.out.println(contarMultiplos4(100));
		for (Integer i : multiplosDe4) {
			System.out.print(i+"->");
		}
		System.out.println();
	}
	public static  int contarMultiplos4(int limiteSuperior) {
		if (limiteSuperior==0) {
			numeroMultiplos++;
			multiplosDe4.add(limiteSuperior);
			return numeroMultiplos;
		}
		if (limiteSuperior%4==0) {
			numeroMultiplos++;
			multiplosDe4.add(limiteSuperior);
			
		}
		contarMultiplos4(limiteSuperior-1);
		return numeroMultiplos;
	}

}
