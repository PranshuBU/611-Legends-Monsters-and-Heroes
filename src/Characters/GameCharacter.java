/*
 * GameCharacter.java
 * This abstract class represents a general game character with attributes like name, level,
 * and health points (HP). It provides methods for managing HP, taking damage, healing, leveling up,
 * and checking if the character is alive. Specific character types, such as heroes and monsters,
 * extend this class and implement their unique stats and behaviors.
 */

package Characters;


public abstract class GameCharacter {
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        calculateStats();
    }

    protected abstract void calculateStats();

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = Math.min(hp, maxHp);
    }
    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
    }
    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
    }
    public boolean isAlive() {
        return hp > 0;
    }

    public void levelUp() {
        level++;
        calculateStats();
    }

    @Override
    public String toString() {
        return String.format("%s (Level %d) - HP: %d/%d", name, level, hp, maxHp);
    }
}