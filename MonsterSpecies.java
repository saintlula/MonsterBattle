public class MonsterSpecies
{
    private String code;
    private String name;
    private String type;
    private int baseHP;
    private int baseAttack;

    //Constructor
    public MonsterSpecies(String code, String name, String type, int baseHP, int baseAttack)
    {
        this.code = code;
        this.name = name;
        this.type = type;
        this.baseHP = baseHP;
        this.baseAttack = baseAttack;
    }

    //Getters
    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public int getBaseHP()
    {
        return baseHP;
    }

    public int getBaseAttack()
    {
        return baseAttack;
    }

    //toString method
    @Override
    public String toString()
    {
        return name + " [" + type + " ] (HP: " + baseHP + ", attack: " + baseAttack + ")";
    }
}