package recursion;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio3 {
	static Random r = new Random();

	public static void main(String[] args) {
		int[] arr = new int[30];
		fillArray(arr, 0);
		System.out.println(Arrays.toString(arr));
		System.out.println(countPairs(arr, 0, 0, 0));
	}
	
	public static void fillArray(int[] arr, int pos) {
		if (pos==30) {
			return;
		}
		arr[pos]= r.nextInt(10);
		fillArray(arr, pos+1);
	}
	
	public static String countPairs(int[] arr, int pos, int pairs,int impairs) {
		if (pos==30) {
			return pairs+" "+impairs;
		}
		int innerPairs=pairs;
		int innerImpairs=impairs;
		if (arr[pos]%2==0) {
			innerPairs++;
		}else {
			innerImpairs++;
		}
		String[] previous= countPairs(arr, pos+1, innerPairs, innerImpairs).split(" ");
		innerPairs=Integer.parseInt(previous[0]);
		innerImpairs=Integer.parseInt(previous[1]);
		return innerPairs+" "+innerImpairs;	
	}

}
