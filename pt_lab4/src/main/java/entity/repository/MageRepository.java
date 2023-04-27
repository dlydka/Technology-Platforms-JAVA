package entity.repository;

import entity.Mage;
import entity.Tower;
import repository.JpaRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MageRepository extends JpaRepository<Mage, Integer> {

    public MageRepository(EntityManagerFactory emf) {
        super(emf, Mage.class);
    }

    public List<Mage> findAllMagesFromTower(Tower tower) {
        EntityManager em = getEmf().createEntityManager();
        List<Mage> mages = em.createQuery("select c from Mage c where c.tower = :tower", Mage.class)
                .setParameter("tower", tower)
                .getResultList();
        em.close();
        return mages;
    }

    public List<Mage> findMinLvl(Tower tower1, Tower tower2) {
        EntityManager em = getEmf().createEntityManager();
        List<Mage> mages = em.createQuery("select c from Mage c where c.tower = :tower and c.level > " +
                        "(select min(c.level) from c where c.tower = :tower1)", Mage.class)
                .setParameter("tower", tower2)
                .setParameter("tower1", tower1)
                .getResultList();
        em.close();
        return mages;
    }
}
