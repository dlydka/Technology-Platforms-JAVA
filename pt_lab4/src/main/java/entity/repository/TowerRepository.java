package entity.repository;

import entity.Tower;
import repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.UUID;

public class TowerRepository extends JpaRepository<Tower, String> {

    public TowerRepository(EntityManagerFactory emf) {
        super(emf, Tower.class);
    }
}
