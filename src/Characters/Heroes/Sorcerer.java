/*
 * Sorcerer.java
 * This class represents the Sorcerer hero, a type of Hero specializing in spellcasting.
 * Sorcerers have high mana points and excel in agility and dexterity, allowing them to
 * cast spells with enhanced effectiveness. The class overrides methods for calculating stats,
 * leveling up, and casting spells, with Sorcerer-specific bonuses that amplify spell damage.
 */

package Characters.Heroes;
import Characters.Monsters.Monster;
import Items.Spell;

public class Sorcerer extends Hero {
    public Sorcerer(String name) {
        super(name);
        inventory.add(new Spell("Flame Thrower", 150, 1, 35, 20, "fire"));
        inventory.add(new Spell("Ice Beam", 150, 1, 35, 20, "ice"));
    }

    @Override
    protected void calculateStats() {
        maxHp = level * 100;
        hp = maxHp;
        maxMp = level * 150;
        mp = maxMp;
        strength = level * 6;
        agility = (int) (level * 6 * 1.25);
        dexterity = (int) (level * 6 * 1.25);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        dexterity = (int) (dexterity * 1.25);
        agility = (int) (agility * 1.25);
    }

    @Override
    public int castSpell(Spell spell, Monster target) {
        int damage = super.castSpell(spell, target);
        return (int) (damage * 1.25);
    }

    @Override
    public String toString() {
        return "Sorcerer's name: " + super.toString();
    }
}