package entity.service;

import entity.Mage;
import entity.Tower;
import entity.repository.MageRepository;
import java.util.List;

public class MageService {
    private final MageRepository repository;

    public MageService(MageRepository repository) {
        this.repository = repository;
    }

    public List<Mage> findAllMages() {
        return repository.findAll();
    }

    public List<Mage> findAllMages(Tower tower) {
        return repository.findAllMagesFromTower(tower);
    }

    public List<Mage> findMinLvl(Tower tower, Tower tower1) {
        return repository.findMinLvl(tower, tower1);
    }

    public void delete(Mage mage) {
        repository.delete(mage);
    }

    public void create(Mage mage) {
        repository.add(mage);
    }

    public Mage findByName(String name) {
        return repository.findByName(name);
    }
}
