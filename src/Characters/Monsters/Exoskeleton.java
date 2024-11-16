/*
 * Exoskeleton.java
 * This class represents the Exoskeleton monster, a type of Monster with enhanced defense.
 * Exoskeletons have a naturally higher defense stat and a chance to further reduce incoming damage
 * due to their hardened shells. The class overrides methods to calculate stats and defend,
 * providing unique behavior specific to Exoskeletons.
 */


package Characters.Monsters;


public class Exoskeleton extends Monster {
    public Exoskeleton(String name, int level) {
        super(name, level);
    }

    @Override
    protected void calculateStats() {
        maxHp = level * 100;
        hp = maxHp;
        baseDamage = level * 15;
        defense = (int)(level * 15 * 1.2);  // Exoskeletons have increased defense (20% increase)
        dodgeChance = 0.15;
    }

    @Override
    public int defend(int incomingDamage) {
        // Exoskeletons have a chance to further reduce incoming damage
        if (Math.random() < 0.2) {  // 20% chance for enhanced defense
            System.out.println(name + " hardens its shell!");
            return super.defend((int)(incomingDamage * 0.8));  // Reduce incoming damage by an additional 20%
        }
        return super.defend(incomingDamage);
    }

    @Override
    public String toString() {
        return "Exoskeleton " + super.toString();
    }
}
