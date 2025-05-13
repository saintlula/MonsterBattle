public class FireMonster extends Monster
{
    public FireMonster(String name, MonsterSpecies species, int hp, int attackPower)
    {
        super(name,species,hp,attackPower);
    }

    @Override
    public void attack(Monster target)
    {
        int damage = this.attackPower;

        String targetType = target.getSpecies().getType();
        if (targetType.equalsIgnoreCase("Grass"))
        {
            damage += 10; //Because fire is bigger than grass
        }

        target.takeDamage(damage);
        System.out.println(this.name + "attacks " + target.getName() + " for " + damage +  " damage!");
    }
}