import entity.repository.MageRepository;
import entity.repository.TowerRepository;
import entity.service.MageService;
import entity.service.TowerService;
import entity.view.*;
import initialize.InitializeTestData;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        boolean initialize = args.length >= 1 && Boolean.parseBoolean(args[0]);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("labPu");

        MageService mageService = new MageService(new MageRepository(emf));
        TowerService towerService = new TowerService(new TowerRepository(emf));

        if (initialize) {
            InitializeTestData initializeTestData = new InitializeTestData(mageService, towerService);
            initializeTestData.init();
        }

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.print("command: ");
            String command = scanner.next();
            switch (command) {
                case "list" -> new DataList(mageService, towerService).display();
                case "add_mage" -> new AddMage(mageService, towerService).display();
                case "add_tower" -> new AddTower(mageService, towerService).display();
                case "delete_mage" -> new DeleteMage(mageService, towerService).display();
                case "delete_tower" -> new DeleteTower(mageService, towerService).display();
                case "query" -> new Query(mageService, towerService).display();
                case "quit" -> running = false;
                default -> System.out.println("unknown command");
            }
        }
        emf.close();
    }
}
