//This file was created for Task 4.
//The robust version of this menu (Task 5) is implemented is called RobustMonsterBattleSystemMenu.java
//Please run that version for exception handling and final testing and not this one.
//This is only for task completing purposes. 
//Thank you :)

import java.util.Scanner;

public class MonsterBattleSystemMenu 
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        MonsterBattleSystem system = new MonsterBattleSystem();

        String option = "";
        while (true)
        {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Monster Battle Quest");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Add Monster Species");
            System.out.println("2. Register Player");
            System.out.println("3. Recruit Monster To Player");
            System.out.println("4. Display Player Info");
            System.out.println("5. Display All Data");
            System.out.println("6. Sava Data");
            System.out.println("7. Load Data");
            System.out.println("8. Battle Between Two PLayers");
            System.out.println("X. Exit");
            System.out.println("Please enter an option between 1-8.\nOr enter X to exit");
            option = scanner.nextLine().trim();

            switch (option.toUpperCase())
            {
                case "1":
                    System.out.print("Enter Species Code  ");
                    String code = scanner.nextLine();
                    System.out.print("Enter Species Name  ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the Species Type  ");
                    String type = scanner.nextLine();
                    System.out.print("Enter the Base HP of Monster  ");
                    int baseHP = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the Base Attack of the Monster  ");
                    int baseAttack = Integer.parseInt(scanner.nextLine());
                    
                    system.addSpecies(code, name, type, baseHP, baseAttack);
                    break;

                case "2":
                    System.out.print("Enter Player ID  ");
                    String playerId = scanner.nextLine();
                    System.out.print("Enter the Player Name  ");
                    String playerName = scanner.nextLine();
                    
                    system.addPlayer(playerId, playerName);
                    break;

                    case "3":
                    System.out.print("Enter Player ID: ");
                    String playerIdForRecruitment = scanner.nextLine();
                
                    System.out.print("Enter Monster Name: ");
                    String monsterName = scanner.nextLine();
                
                    System.out.print("Enter Species Code: ");
                    String speciesCodeForRecruitment = scanner.nextLine();
                
                    system.assignMonster(playerIdForRecruitment, monsterName, speciesCodeForRecruitment);
                    break;

                case "4":
                    System.out.print("Enter Player ID to Display  ");
                    String idToDisplay = scanner.nextLine();
                    System.out.println(system.displayPlayer(idToDisplay));
                    break;

                case "5":
                    System.out.println(system);
                    break;

                case "6":
                    system.saveData();
                    System.out.println("Data has been saved successfully");
                    break;

                case "7":
                    system.loadData();
                    System.out.println("Data has been loaded successfully");
                    break;

                case "8":
                    System.out.print("Enter First Player ID  ");
                    String playerOne = scanner.nextLine();
                    System.out.print("Enter Second Player ID  ");
                    String playerTwo = scanner.nextLine();
                    String result = system.battle(playerOne, playerTwo);
                    System.out.println(result);
                    break;
                
                case "X":
                    System.out.println("Exiting the program... BYE!");
                    return;

                default:
                    System.out.println("That seems to be invalid. Please try again, correctly this time :) ");
                    break;
            }
            //Spacer between the options
            System.out.println();
        }
    }
}
