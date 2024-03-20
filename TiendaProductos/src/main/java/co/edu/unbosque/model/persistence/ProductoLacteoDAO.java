package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProductoLacteo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductoLacteoDAO implements CRUDOperation<ProductoLacteo> {

	public EntityManagerFactory emf;
	public EntityManager em;

	public ProductoLacteoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}

	public void open() {
		if (!emf.isOpen() || !em.isOpen()) {
			emf = Persistence.createEntityManagerFactory("default");
			em = emf.createEntityManager();
		}
	}

	@Override
	public void create(ProductoLacteo obj) {

		try {
			open();
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}

	}

	@Override
	public boolean delete(long id) {
		open();
		try {
			// Delete
			em.getTransaction().begin();
			em.remove(em.find(ProductoLacteo.class, id));
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return false;
	}

	@Override
	public boolean update(long id, ProductoLacteo obj) {
		open();
		try {
			// Update
			em.getTransaction().begin();
			ProductoLacteo selected = em.find(ProductoLacteo.class, id);

			selected.setId(obj.getId());
			selected.setNombreProducto(obj.getNombreProducto());
			selected.setEmpresaProductora(obj.getEmpresaProductora());
			selected.setCostoFabricacion(obj.getCostoFabricacion());
			selected.setCostoVenta(obj.getCostoVenta());
			selected.setLibreLactosa(obj.isLibreLactosa());
			em.persist(selected);
			em.getTransaction().commit();
			return true;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ProductoLacteo> readAll() {
		open();
		try {
			// usando JPQL
			return (ArrayList<ProductoLacteo>) em.createQuery("select p from ProductoLacteo p").getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return new ArrayList<ProductoLacteo>();

	}

	@Override
	public ProductoLacteo findOne(long id) {
		open();
		try {
			// Find
			ProductoLacteo selectedProductoLacteo = em.find(ProductoLacteo.class, id);
			return selectedProductoLacteo;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (emf != null) {
				emf.close();
			}
			if (em != null) {
				em.close();
			}
		}
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
