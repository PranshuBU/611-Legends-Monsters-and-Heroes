/*
 * Potion.java
 * This class represents a healing potion that heroes can use to restore health.
 * Each potion has a healing amount and a limited number of uses (typically one).
 * When used, the potion heals the hero, and the use count decreases. The class also
 * includes methods to display potion details, check usability, and get the item type.
 */


package Items;

import Characters.Heroes.Hero;

public class Potion extends Item {
    private int healingAmount;

    public Potion(String name, int price, int level, int healingAmount) {
        super(name, price, level, 1); // Potions typically have only one use
        this.healingAmount = healingAmount;
    }

    @Override
    public void use(Hero hero) {
        if (isUsable()) {
            hero.setHp(Math.min(hero.getHp() + healingAmount, hero.getMaxHp()));
            System.out.println(hero.getName() + " used " + getName() + " and healed for " + healingAmount + " HP.");
            super.use(); // Decrease remaining uses
        } else {
            System.out.println("This potion has already been used.");
        }
    }

    @Override
    public String getItemType() {
        return "Potion";
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    @Override
    public String toString() {
        return String.format("%s (Level %d Potion) - Heals: %d HP, Price: %d gold, Uses left: %d",
                getName(), getLevel(), healingAmount, getPrice(), getRemainingUses());
    }
}