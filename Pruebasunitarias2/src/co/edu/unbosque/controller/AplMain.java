package co.edu.unbosque.controller;

public class AplMain {
	
	public static double sumar(double ... nums) {
		double res=0;
		for (int i = 0; i < nums.length; i++) {
			res+=nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(sumar(3,4));
		System.out.println(sumar(3,4,5,6,7));
		System.out.println(sumar(3,4,10,-1,6,1,2,3,4,5,3,4,43));
		System.out.println(sumar(3,4,0));
		System.out.println(sumar(3,4,-100));

	}

}
