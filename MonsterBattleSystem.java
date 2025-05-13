public class MonsterBattleSystem 
{
    private MonsterSpecies[] speciesList;
    private Player[] players;
    private int speciesCount;
    private int playerCount;
    
    public MonsterBattleSystem() 
    {
        this.speciesList = new MonsterSpecies[50];
        this.players = new Player[100];
        this.speciesCount = 0;
        this.playerCount = 0;
    }

    public void addSpecies(String code, String name, String type, int baseHP, int baseAttack)
    {
        //check for duplicate species code
        for (int i = 0; i < speciesCount; i++)
        {
            if (speciesList[i].getCode().equals(code))
            {
                System.out.println("This species code seems to already exist: " + code);
                return;
            }
        }
        speciesList[speciesCount++] = new MonsterSpecies(code, name, type, baseHP, baseAttack);
    }
    public void addPlayer(String playerId, String name)
    {
        //check for duplicate player aswell
        for (int i = 0; i < playerCount; i++)
        {
            if (players[i].getPlayerId().equals(playerId))
            {
                System.out.println("This player ID seem to already exist: " + playerId);
                return;
            }
        }
        players[playerCount++] = new Player(playerId, name);
    }

    public void assignMonster(String playerId, String monsterName, String speciesCode)
    {
        Player player = findPlayer(playerId);
        if (player == null)
        {
            System.out.println("Player not found: " + playerId);
            return;
        }
        MonsterSpecies species = findSpecies(speciesCode);
        if (species == null)
        {
            System.out.println("Species not found: " + speciesCode);
            return;
        }
        
        Monster monster = createMonsterFromSpecies(species, monsterName);
        player.addMonster(monster);
    }

    private Monster createMonsterFromSpecies(MonsterSpecies species, String name)
    {
        int hp = species.getBaseHP();
        int attack = species.getBaseAttack();
        String type = species.getType();
        if (type.equalsIgnoreCase("Fire"))
        {
            return new FireMonster(name, species, hp, attack);
        }
            else if (type.equalsIgnoreCase("Water"))
            {
                return new WaterMonster(name, species, hp, attack);
            }
            else if (type.equalsIgnoreCase("Grass"))
            {
                return new GrassMonster(name, species, hp, attack);
            }
            return null; //Shouldnt happen as long as types are correct
    }

    private MonsterSpecies findSpecies(String code)
    {
        for (int i = 0; i < speciesCount; i++)
        {
            if (speciesList[i].getCode().equals(code))
            {
                return speciesList[i];
            }
        }
        return null;
    }

    private Player findPlayer(String playerId)
    {
        for (int i = 0; i < playerCount; i++)
        {
            if (players[i].getPlayerId().equals(playerId))
            {
                return players[i];
            }
        }
        return null;
    }
    
    public String battle(String player1ID, String player2ID)
    {
        Player p1 = findPlayer((player1ID));
        Player p2 = findPlayer(player2ID);

        if (p1 == null || p2 == null)
        {
            return "One or both players were not found!";
        }

        Monster m1 = p1.getNextAliveMonster();
        Monster m2 = p2.getNextAliveMonster();

        StringBuilder result = new StringBuilder();
        result.append("Battle Start: ").append(p1.getName()).append( "  vs  ").append(p2.getName()).append("\n");

        while (m1 != null && m2 != null)
        {
            result.append(m1.getName()).append("  attacks  ").append(m2.getName()).append("\n");
            m1.attack(m2);

            if (!m2.isFainted())
            {
                result.append(m2.getName()).append("  attacks  ").append(m1.getName()).append("\n");
                m2.attack(m1);
            }
            if (m1.isFainted())
            {
                result.append(m1.getName()).append(" has fainted!\n");
                m1 = p1.getNextAliveMonster();
            }
            if (m2.isFainted())
            {
                result.append(m2.getName()).append(" has fainted!\n");
                m2 = p2.getNextAliveMonster();
            }
        }
        if (p1.hasAliveMonster())
        {
            result.append(p1.getName()).append(" wins the battle! Congradulations!\n");
        }
            else if (p2.hasAliveMonster())
            {
                result.append(p2.getName()).append(" wins the battle! Congradulations!\n");
            }
            else
            {
                result.append("All monsters have fainted! The battle is a draw!");
            }
            return result.toString();
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Monster Battle System\n");
        sb.append("Registered Species Are:\n");
        for (int i = 0; i < speciesCount; i++)
        {
            sb.append("  ").append(speciesList[i].toString()).append("\n");
        }
        sb.append("Registered Players:\n");
        for (int i = 0; i < playerCount; i++)
        {
            sb.append("  ").append(players[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
