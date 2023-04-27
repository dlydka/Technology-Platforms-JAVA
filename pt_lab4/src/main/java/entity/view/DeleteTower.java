package entity.view;

import entity.Mage;
import entity.Tower;
import entity.service.MageService;
import entity.service.TowerService;
import view.View;

import java.util.List;
import java.util.Scanner;

public class DeleteTower implements View{
    private final MageService mageService;

    private final TowerService towerService;

    public DeleteTower(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();

        Tower towerEntity = towerService.find(name);

        if (towerEntity == null) {
            System.out.println("No such tower");
        } else {
            List<Mage> mages = mageService.findAllMages(towerEntity);
            if (mages != null) {
                for (Mage mage : mages) {
                    mageService.delete(mage);
                }
                towerService.delete(towerEntity);
            }
        }
    }
}
