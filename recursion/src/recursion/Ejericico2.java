package recursion;

public class Ejericico2 {
	static int cont = 0;

	public static void main(String[] args) {
		contarVocales("novia perro sancocho cielo tejo 6541654", cont);
		System.out.println(cont);

	}


	public static void contarVocales(String frase, int pos) {
		if (pos == frase.length()) {
			return;
		}
		if ((frase.charAt(pos) + "").matches("[aeiouAEIOU]")) {
			cont++;
		}
		contarVocales(frase, pos+1);

	}

}
