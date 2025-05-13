public class TestMonsterBattleSystem {
    public static void main(String[] args) throws Exception {
        // Create an instance of the battle system
        MonsterBattleSystem system = new MonsterBattleSystem();

        // Add species to the system
        system.addSpecies("FD001", "FireDragon", "Fire", 100, 50);
        system.addSpecies("WD002", "AquaSerpent", "Water", 110, 45);
        system.addSpecies("GD003", "LeafBeast", "Grass", 90, 55);

        // Add players to the system
        system.addPlayer("P100", "John");
        system.addPlayer("P200", "Alice");
        system.addPlayer("P300", "Bob");

        // Assign monsters to players
        system.assignMonster("P100", "Blaze", "FD001");
        system.assignMonster("P200", "Sprout", "GD003");
        system.assignMonster("P300", "Aqua", "WD002");

        // Save the current state to files
        system.saveData();

        // Print confirmation
        System.out.println(">>> Game state saved to files.");

        // Now load the saved state into a new system instance
        MonsterBattleSystem loadedSystem = new MonsterBattleSystem();
        loadedSystem.loadData();

        // Print confirmation
        System.out.println(">>> Game state loaded from files.");

        // Test a battle with the loaded system
        System.out.println(loadedSystem.battle("P100", "P200")); // Blaze vs. Sprout

        // Print the full system state
        System.out.println(loadedSystem);
    }
}