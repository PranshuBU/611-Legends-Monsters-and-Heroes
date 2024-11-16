/*
 * Spell.java
 * This class represents a spell that heroes can use to deal damage and apply effects on monsters.
 * Each spell has a damage value, mana cost, and a specific type (e.g., ice, fire, lightning) that determines
 * additional effects on the target. The spell can reduce the target’s damage, defense, or dodge chance
 * based on its type. The class includes methods to display spell details and get the item type.
 */

package Items;

import Characters.Heroes.Hero;
import Characters.Monsters.Monster;

public class Spell extends Item {
    private int damage;
    private int manaCost;
    private String spellType;

    public Spell(String name, int price, int level, int damage, int manaCost, String spellType) {
        super(name, price, level,damage);
        this.damage = damage;
        this.manaCost = manaCost;
        this.spellType = spellType;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getSpellType() {
        return spellType;
    }

    public void applyEffect(Monster target) {
        switch (spellType.toLowerCase()) {
            case "ice":
                target.reduceDamage();
                System.out.println(target.getName() + "'s damage has been reduced!");
                break;
            case "fire":
                target.reduceDefense();
                System.out.println(target.getName() + "'s defense has been reduced!");
                break;
            case "lightning":
                target.reduceDodgeChance();
                System.out.println(target.getName() + "'s dodge chance has been reduced!");
                break;
            default:
                System.out.println("Unknown spell type: " + spellType);
        }
    }

    @Override
    public String getItemType() {
        return "Spell";
    }

    @Override
    public void use(Hero hero) {
        super.use();
        System.out.println(getName() + " spell has been cast by " + hero.getName() + "!");
    }

    @Override
    public String toString() {
        return String.format("%s (Level %d %s Spell) - Damage: %d, Mana Cost: %d, Price: %d gold, Uses left: %d",
                getName(), getLevel(), spellType, damage, manaCost, getPrice(), getRemainingUses());
    }
}
