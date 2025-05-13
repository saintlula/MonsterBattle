//This is the robust and complete version of the "Menu" with error handling.
import java.util.Scanner;

public class RobustMonsterBattleSystemMenu {

    public static void main(String[] args) {
        MonsterBattleSystem system = new MonsterBattleSystem();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("~~~~~~~~~====~~~~~~~~~~~");
            System.out.println("Monster Battle Quest");
            System.out.println("~~~~~~~~~====~~~~~~~~~~~");
            System.out.println("1. Add Monster Species");
            System.out.println("2. Register Player");
            System.out.println("3. Recruit Monster to Player");
            System.out.println("4. Display Player Info");
            System.out.println("5. Display All Data");
            System.out.println("6. Save Data");
            System.out.println("7. Load Data");
            System.out.println("8. Battle Between Two Players");
            System.out.println("X. Exit");
            System.out.print("Please enter an option (1-8 or X): ");
            choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter species code: ");
                        String code = scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter type: ");
                        String type = scanner.nextLine();
                        System.out.print("Enter base HP: ");
                        int hp = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter base attack: ");
                        int attack = Integer.parseInt(scanner.nextLine());
                        system.addSpecies(code, name, type, hp, attack);
                        break;

                    case "2":
                        System.out.print("Enter player ID: ");
                        String playerId = scanner.nextLine();
                        System.out.print("Enter player name: ");
                        String playerName = scanner.nextLine();
                        system.addPlayer(playerId, playerName);
                        break;

                    case "3":
                        System.out.print("Enter player ID: ");
                        String pid = scanner.nextLine();
                        System.out.print("Enter monster name: ");
                        String monsterName = scanner.nextLine();
                        System.out.print("Enter species code: ");
                        String speciesCode = scanner.nextLine();
                        system.assignMonster(pid, monsterName, speciesCode);
                        break;

                    case "4":
                        System.out.print("Enter Player ID to Display: ");
                        String idToDisplay = scanner.nextLine();
                        System.out.println(system.displayPlayer(idToDisplay));
                        break;

                    case "5":
                        System.out.println(system);
                        break;

                    case "6":
                        system.saveData();
                        System.out.println("Data saved successfully.");
                        break;

                    case "7":
                        system.loadData();
                        System.out.println("Data loaded successfully.");
                        break;

                    case "8":
                        System.out.print("Enter ID of Player 1: ");
                        String p1 = scanner.nextLine();
                        System.out.print("Enter ID of Player 2: ");
                        String p2 = scanner.nextLine();
                        String result = system.battle(p1, p2);
                        System.out.println(result);
                        break;

                    case "X":
                    case "x":
                        System.out.println("Exiting... Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

        } while (!choice.equalsIgnoreCase("X"));

        scanner.close();
    }
}