public class GrassMonster extends Monster
{
    public GrassMonster(String name, MonsterSpecies species, int hp, int attackPower)
    {
        super(name,species,hp,attackPower);
    }

    @Override
    public void attack(Monster target)
    {
        int damage = this.attackPower;

        String targetType = target.getSpecies().getType();
        if (targetType.equalsIgnoreCase("Water"))
        {
            damage += 10; //Because grass is bigger than water!
        }

        target.takeDamage(damage);
        System.out.println(this.name + "attacks " + target.getName() + " for " + damage +  " damage!");
    }
}