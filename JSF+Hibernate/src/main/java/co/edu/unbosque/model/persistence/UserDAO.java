package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO implements CRUDOperation {

	public EntityManagerFactory emf;
	public EntityManager em;

	public UserDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public void open() {
		if (!emf.isOpen()||!em.isOpen()) {
			emf = Persistence.createEntityManagerFactory("default");
			em = emf.createEntityManager();
		}
	}

	@Override
	public void create(Object o) {
		open();
		try {
			// Insert
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();

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

	}

	@Override
	public boolean delete(long id) {
		open();
		try {
			// Delete
			em.getTransaction().begin();
			em.remove(em.find(User.class, id));
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
	public boolean update(long id, Object o) {
		open();
		try {
			// Update
			em.getTransaction().begin();
			User selectedUser = em.find(User.class, id);
			User newData = (User) o;
			selectedUser.setUsername(newData.getUsername());
			selectedUser.setPasskey(newData.getPasskey());
			em.persist(selectedUser);
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
	public ArrayList<User> findAll() {
		open();
		try {
			return (ArrayList<User>) em.createQuery("select u from User u").getResultList();
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
		return new ArrayList<User>();
	}

	@Override
	public Object findOne(long id) {
		open();
		try {
            //Find
            User selectedUser = em.find(User.class, id);
            return selectedUser;
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

}
