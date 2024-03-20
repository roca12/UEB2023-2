import java.util.ArrayList;

public class Database {
	private ArrayList<Integer> numeros;
	private int[] primos;
	private boolean proyectoFacil;
	
	
	public Database() {
		numeros= new ArrayList<>();
		primos= new int[10];
		proyectoFacil=false;
	}


	public ArrayList<Integer> getNumeros() {
		return numeros;
	}


	public void setNumeros(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}


	public int[] getPrimos() {
		return primos;
	}


	public void setPrimos(int[] primos) {
		this.primos = primos;
	}


	public boolean isProyectoFacil() {
		return proyectoFacil;
	}


	public void setProyectoFacil(boolean proyectoFacil) {
		this.proyectoFacil = proyectoFacil;
	}
	
	
}
