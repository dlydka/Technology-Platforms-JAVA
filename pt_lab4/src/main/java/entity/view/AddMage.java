package entity.view;

import entity.Mage;
import entity.Tower;
import entity.service.MageService;
import entity.service.TowerService;
import view.View;
import java.util.Scanner;


public class AddMage implements View {

    private final MageService mageService;

    private final TowerService towerService;

    public AddMage(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("level: ");
        int level = Integer.parseInt(scanner.nextLine());
        System.out.print("tower: ");
        String tower = scanner.nextLine();

        Tower towerEntity = towerService.find(tower);
        if (towerEntity == null) {
            System.out.println("No such Tower");
        } else {
            mageService.create(Mage.builder()
                    .name(name)
                    .level(level)
                    .tower(towerEntity)
                    .build());
        }
    }

}
