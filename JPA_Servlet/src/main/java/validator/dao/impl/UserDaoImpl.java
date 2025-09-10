package validator.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import validator.configs.JPAConfig;
import validator.entity.User;
import validator.dao.UserDao;

public class UserDaoImpl implements UserDao {
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.username = :u AND u.password = :p", User.class);
			q.setParameter("u", username);
			q.setParameter("p", password);
			return q.getResultStream().findFirst().orElse(null);
		} finally {
			em.close();
		}
	}
	
	@Override
	public User findById(int id) {
		EntityManager em = JPAConfig.getEntityManager();
		try { 
			return em.find(User.class, id); 
		}
		finally { 
			em.close();
		}
	}
	
	@Override
	public User findByEmail(String email) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.email = :e", User.class);
			q.setParameter("e", email);
			return q.getResultStream().findFirst().orElse(null);
		} finally {
			em.close();
		}
	}
	
	@Override
	public void insert(User user) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch(Exception ex) {
			if (em.getTransaction().isActive()) em.getTransaction().rollback();
			throw ex;
		} finally {
			em.close();
		}
	}
	
	@Override
	public boolean existByUsername(String username) {
		return findByUsernameAndPassword(username, "") != null;
	}
	
	@Override
	public boolean existByEmail(String email) {
		return findByEmail(email) != null;
	}
}
