public class WaterMonster extends Monster
{
    public WaterMonster(String name, MonsterSpecies species, int hp, int attackPower)
    {
        super(name,species,hp,attackPower);
    }

    @Override
    public void attack(Monster target)
    {
        int damage = this.attackPower;

        String targetType = target.getSpecies().getType();
        if (targetType.equalsIgnoreCase("Fire"))
        {
            damage += 10; //Because water is bigger than fire!
        }

        target.takeDamage(damage);
        System.out.println(this.name + "attacks " + target.getName() + " for " + damage +  " damage!");
    }
}