
/*
 * Armor.java
 * This class defines armor items that heroes can equip to reduce incoming damage.
 * Armor extends the base Item class and includes a specific damage reduction value.
 * When used, the armor is equipped by the hero, and it provides protection against attacks.
 * The class also includes methods to display armor details and retrieve the item type.
 */

package Items;


import Characters.Heroes.Hero;

public class Armor extends Item {
    private int damageReduction;

    public Armor(String name, int price, int level, int damageReduction) {
        super(name, price, level, 1); // Armor typically doesn't have uses, so set it to 1
        this.damageReduction = damageReduction;
    }

    @Override
    public void use(Hero hero) {
        hero.equipArmor(this);
        System.out.println(hero.getName() + " equipped " + getName() + " armor!");
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    @Override
    public String getItemType() {
        return "Armor";
    }

    @Override
    public String toString() {
        return String.format("%s (Level %d Armor) - Damage Reduction: %d, Price: %d gold",
                getName(), getLevel(), damageReduction, getPrice());
    }
}
