package entity.view;

import entity.Mage;
import entity.service.MageService;
import entity.service.TowerService;
import view.View;

import java.util.Scanner;

public class DeleteMage implements View {

    private final MageService mageService;
    private final TowerService towerService;

    public DeleteMage(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();

        Mage mageEntity = mageService.findByName(name);
        if (mageEntity == null) {
            System.out.println("No such book");
        } else {
            mageService.delete(mageEntity);
        }
    }
}
