package entity.view;

import entity.Mage;
import entity.Tower;
import entity.service.MageService;
import entity.service.TowerService;
import view.View;

public class DataList implements View {

    private final MageService mageService;

    private final TowerService towerService;

    public DataList(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        int number = 1;
        System.out.println("Mages:");
        for (Mage mage : mageService.findAllMages()) {
            System.out.println(number + ") " + mage);
            number++;
        }
        System.out.println();

        System.out.println("Towers:");
        number = 1;
        for (Tower tower : towerService.findAllTowers()) {
            System.out.println(number + ") " + tower);
            number++;
        }
        System.out.println();
    }
}
