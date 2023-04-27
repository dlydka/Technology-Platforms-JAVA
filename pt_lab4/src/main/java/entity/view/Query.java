package entity.view;

import entity.Tower;
import entity.Mage;
import entity.service.MageService;
import entity.service.TowerService;
import view.View;
import java.util.Scanner;

public class Query implements View {
    private final MageService mageService;

    private final TowerService towerService;

    public Query(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name 1: ");
        String tower1 = scanner.nextLine();
        System.out.print("name 2: ");
        String tower2 = scanner.nextLine();

        Tower towerEntity = towerService.find(tower1);
        Tower towerEntity1 = towerService.find(tower2);
        if (towerEntity == null) {
            System.out.println("No such Tower");
        } else {
            for (Mage mage : mageService.findMinLvl(towerEntity, towerEntity1)) {
                System.out.println(mage);
            }

        }
    }
}