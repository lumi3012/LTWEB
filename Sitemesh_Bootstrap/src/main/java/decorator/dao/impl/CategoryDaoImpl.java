package decorator.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import decorator.config.JPAConfig;
import decorator.dao.CategoryDao;
import decorator.entity.Category;

public class CategoryDaoImpl implements CategoryDao {

	private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("decoratorPU");
	
	@Override
	public void insert(Category cate) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(cate);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
		
	
	@Override
	public void update(Category cate) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(cate);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
		
	}

	@Override
	public void delete(int id) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			Category cate = em.find(Category.class, id);
			if (cate != null) em.remove(cate);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}


	@Override
	public Category findById(int id) {
		EntityManager em = emf.createEntityManager();
        try {
            return em.find(Category.class, id);
        } finally {
            em.close();
        }
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}



	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}



	@Override
	public List<Category> findAll() {
		EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Category c", Category.class)
                    .getResultList();
        } finally {
            em.close();
        }
	}
	
	@Override 
	public List<Category> findAllByUserId(int userId) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<Category> q = em.createQuery("SELECT c FROM Category c WHERE c.user.id = :uid", Category.class);
			q.setParameter("uid", userId);
			return q.getResultList();
		} finally {
			em.close();
		}
	}
	
}
