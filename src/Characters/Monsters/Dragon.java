/*
 * Dragon.java
 * This class represents the Dragon monster, a type of Monster known for high base damage.
 * Dragons have a unique ability to perform a special fire breath attack, which deals extra damage.
 * The class overrides methods for calculating stats and attacking, introducing the fire breath
 * with a 20% chance to inflict 50% more damage.
 */


package Characters.Monsters;


public class Dragon extends Monster {
    public Dragon(String name, int level) {
        super(name, level);
    }

    @Override
    protected void calculateStats() {
        maxHp = level * 100;
        hp = maxHp;
        baseDamage = (int)(level * 20 * 1.2);  // Dragons have increased base damage (20% increase)
        defense = level * 10;
        dodgeChance = 0.1;
    }

    @Override
    public int attack() {
        // Dragons have a chance to perform a special fire breath attack
        if (Math.random() < 0.2) {  // 20% chance for special attack
            System.out.println(name + " uses fire breath!");
            return (int)(baseDamage * 1.5);  // Fire breath does 50% more damage
        }
        return super.attack();
    }

    @Override
    public String toString() {
        return "Dragon " + super.toString();
    }
}
