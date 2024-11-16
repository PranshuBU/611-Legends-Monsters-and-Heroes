/*
 * Warrior.java
 * This class represents the Warrior hero, a subclass of Hero with a focus on strength and agility.
 * Warriors have enhanced strength and agility scaling, making them effective in physical combat.
 * The class overrides methods for calculating stats, leveling up, and getting attack damage,
 * applying Warrior-specific bonuses to these attributes.
 */

package Characters.Heroes;
public class Warrior extends Hero {
    public Warrior(String name) {
        super(name);
    }

    @Override
    protected void calculateStats() {
        maxHp = level * 100;
        hp = maxHp;
        maxMp = level * 120;
        mp = maxMp;
        strength = (int)(level * 4 * 1.10);
        agility = (int)(level * 4 * 1.10);
        dexterity = level * 4;
    }

    @Override
    public void levelUp() {
        super.levelUp();

        strength = (int)(strength * 1.10);
        agility = (int)(agility * 1.10);
    }

    @Override
    public int getAttackDamage() {
        return (int)(super.getAttackDamage() * 1.10);
    }

    @Override
    public String toString() {
        return "Warrior's name" + super.toString();
    }
}