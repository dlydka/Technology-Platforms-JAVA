package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class JpaRepository<E, K> {

    private final EntityManagerFactory emf;
    private final Class<E> clazz;

    public JpaRepository(EntityManagerFactory emf, Class<E> clazz) {
        this.emf = emf;
        this.clazz = clazz;
    }

    public List<E> findAll() {
        EntityManager em = emf.createEntityManager();
        List<E> list = em.createQuery("select e from " + clazz.getSimpleName() + " e", clazz).getResultList();
        em.close();
        return list;
    }

    public E find(K id) {
        EntityManager em = emf.createEntityManager();
        E entity = em.find(clazz, id);
        em.close();
        return entity;
    }

    public E findByName(String name) {
        EntityManager em = emf.createEntityManager();
        E entity = em.find(clazz, name);
        em.close();
        return entity;
    }

    public void delete(E entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.merge(entity));
        transaction.commit();
        em.close();
    }

    public void add(E entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
        em.close();
    }

    protected EntityManagerFactory getEmf() {
        return emf;
    }
}
