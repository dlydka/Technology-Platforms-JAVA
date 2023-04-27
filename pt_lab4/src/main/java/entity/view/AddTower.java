package entity.view;

import entity.Tower;
import entity.service.MageService;
import entity.service.TowerService;
import view.View;
import java.util.Scanner;


public class AddTower implements View {
    private final MageService mageService;

    private final TowerService towerService;

    public AddTower(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("height: ");
        int height = Integer.parseInt(scanner.nextLine());

        Tower towerEntity = towerService.find(name);
        if (towerEntity == null) {
            towerService.create(Tower.builder()
                    .name(name)
                    .height(height)
                    .build());
        } else {
            System.out.println("Tower with such name already exists");
        }
    }
}
