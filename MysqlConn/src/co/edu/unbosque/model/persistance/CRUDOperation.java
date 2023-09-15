package co.edu.unbosque.model.persistance;

public interface CRUDOperation {
	
	public void create(String ... args);
	
	public String readAll();

	public boolean update(int index, String... args);

	public boolean delete(int index);

}
