package initialize;

import entity.Mage;
import entity.Tower;
import entity.service.MageService;
import entity.service.TowerService;

public class InitializeTestData {
    private final MageService mageService;

    private final TowerService towerService;

    public InitializeTestData(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    public void init() {
        Tower tower1 = Tower.builder()
                .name("Tower1")
                .height(1)
                .build();
        Tower tower2 = Tower.builder()
                .name("Tower2")
                .height(2)
                .build();
        Tower tower3 = Tower.builder()
                .name("Tower3")
                .height(3)
                .build();

        towerService.create(tower1);
        towerService.create(tower2);
        towerService.create(tower3);

        Mage mage1 = Mage.builder()
                .name("Mage1")
                .level(1)
                .tower(tower1)
                .build();

        Mage mage2 = Mage.builder()
                .name("Mage2")
                .level(2)
                .tower(tower1)
                .build();

        Mage mage3 = Mage.builder()
                .name("Mage3")
                .level(3)
                .tower(tower1)
                .build();

        Mage mage4 = Mage.builder()
                .name("Mage4")
                .level(4)
                .tower(tower1)
                .build();

        Mage mage5 = Mage.builder()
                .name("Mage5")
                .level(3)
                .tower(tower2)
                .build();

        Mage mage6 = Mage.builder()
                .name("Mage6")
                .level(0)
                .tower(tower2)
                .build();

        Mage mage7 = Mage.builder()
                .name("Mage7")
                .level(2)
                .tower(tower2)
                .build();

        Mage mage8 = Mage.builder()
                .name("Mage8")
                .level(2)
                .tower(tower3)
                .build();

        mageService.create(mage1);
        mageService.create(mage2);
        mageService.create(mage3);
        mageService.create(mage4);
        mageService.create(mage5);
        mageService.create(mage6);
        mageService.create(mage7);
        mageService.create(mage8);
    }
}
