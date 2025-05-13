//Abstract monster.java
public abstract class Monster 
{
    protected String name;
    protected MonsterSpecies species;
    protected int level;
    protected int hp;
    protected int attackPower;

    //Constructor
    public Monster(String name, MonsterSpecies species, int hp, int attackPower)
    {
        this.name = name;
        this.species = species;
        this.level = 1;
        this.hp = hp;
        this.attackPower = attackPower;
    }
    //Abstract attack method, will be implemented in subclasses. 
    public abstract void attack(Monster target);
    //Reduces HP by the given amount
    public void takeDamage(int amount)
    {
        this.hp -= amount;
        if (this.hp < 0)
        {
            this.hp = 0;
        }
    }
    
    //To check if the monster is fainted or not
    public boolean isFainted()
    {
        return this.hp <= 0;
    }
    //String representation
    @Override
    public String toString()
    {
        return name + " (" +species.getName() + ", Lv." + level + ", HP" + hp + " )";
    }

    //Getters
    public String getName()
    {
        return name;
    }

    public MonsterSpecies getSpecies()
    {
        return species;
    }

    public int getLevel()
    {
        return level;
    }

    public int getHp()
    {
        return hp;
    }

    public int getAttackPower()
    {
        return attackPower;
    }
}
