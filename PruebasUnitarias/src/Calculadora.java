
public class Calculadora {
	
	public double sumar(double ... nums) {
		double res=0;
		for (double d : nums) {
			res+=d;
		}
		return res;
	}

}
