public class Player
{
    private String playerId;
    private String name;
    private Monster[] team; //Array
    private int monsterCount;

    //Constructor
    public Player(String playerId, String name)
    {
        this.playerId = playerId; //UID
        this.name = name;
        this.team = new Monster[5]; //Array holding up to 5 monsters
        this.monsterCount = 0; //Track how many monsters in a team
    }

    //Add monster to a team
    public void addMonster(Monster monster)
    {
        //Make sure team isnt over the limit
        if (monsterCount >= 5)
        {
            System.out.print.ln("Team seems to be full! No more monster adding allowed!");
            return;
        }
        //make sure the monster already isnt in the team
        for (int i = 0; i < monsterCount; i++)
        {
            if (team[i] == monster)
            {
                System.out.println("This monster already seems to be in the team!");
                return;
            }
        }
        //add monster
        team[monsterCount] = monster;
        monsterCount++;
        System.out.print.ln(monster.getName() + " added to " + name + "'s team! Congrats!");
    }
    //Check if the monster is still alive
    public boolean hasAliveMonster()
    {
        for (int i = 0; i < monsterCount; i++)
        {
            if (!team[i].isFainted())
            {
                return true;
            }
        }
        return false;
    }

    //Get the next alive monster
    public Monster getNextAliveMonster()
    {
        for (int i = 0; i < monsterCount; i++)
        {
            if (!team[i].isFainted())
            {
                return team[i];
            }
        }
        return null;
    }

    //toString method (scalable)
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" [").append(playerId).append(" ]").append(" Team:\n");
        for (int i = 0; i < monsterCount; i++)
        {
            sb.append(" ").append(team[i].toString()).append("\n");
        }
        return sb.toString();
    }

    //Getter methods
    public String getPlayerId()
    {
        return playerId;
    }
    public String getName()
    {
        return name;
    }
    public Monster[] getTeam()
    {
        return team;
    }
    public int getMonsterCount()
    {
        return monsterCount;
    }
}