
/*
 * Paladin.java
 * This class represents the Paladin hero, a type of Hero characterized by high strength and dexterity.
 * Paladins excel in physical combat and have moderate agility and mana points. The class overrides
 * methods to calculate stats, level up, and cast spells, applying Paladin-specific bonuses that enhance
 * their attack damage and spell effectiveness.
 */

package Characters.Heroes;


import Characters.Monsters.Monster;
import Items.Spell;

public class Paladin extends Hero {
    public Paladin(String name) {
        super(name);
    }

    @Override
    protected void calculateStats() {
        maxHp = level * 100;
        hp = maxHp;
        maxMp = level * 60;
        mp = maxMp;
        strength = (int) (level * 7 * 1.10);
        agility = level * 2;
        dexterity = (int) (level * 7 * 1.10);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        strength = (int) (strength * 1.10);
        dexterity = (int) (dexterity * 1.10);
    }

    @Override
    public int getAttackDamage() {
        return (int) (super.getAttackDamage() * 1.10);
    }

    @Override
    public int castSpell(Spell spell, Monster target) {
        int damage = super.castSpell(spell, target);
        return (int) (damage * 1.10);
    }

    @Override
    public String toString() {
        return "Paladin " + super.toString();
    }
}