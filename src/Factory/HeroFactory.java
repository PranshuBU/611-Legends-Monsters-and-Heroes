/*
 * HeroFactory.java
 * This factory class is responsible for creating various hero types for the game.
 * It implements the CharacterFactory interface and provides methods to generate random heroes
 * or create specific hero types, such as Warrior, Sorcerer, and Paladin, based on inputs.
 * The class includes a method for creating a random hero at a specified level and another
 * for creating a hero of a specific type.
 */


package Factory;

import Characters.GameCharacter;
import Characters.Heroes.*;

import java.util.Random;

public class HeroFactory implements CharacterFactory {
    @Override
    public GameCharacter createCharacter(String name, int level) {
        Random rand = new Random();
        int type = rand.nextInt(3);
        Hero hero;

        switch (type) {
            case 0:
                hero = new Warrior(name);
                break;
            case 1:
                hero = new Sorcerer(name);
                break;
            case 2:
                hero = new Paladin(name);
                break;
            default:
                hero = new Warrior(name);
        }
        for (int i = 1; i < level; i++) {
            hero.levelUp();
        }
        return hero;
    }

    public Hero createSpecificHero(String name, String type) {
        switch (type.toLowerCase()) {
            case "warrior":
                return new Warrior(name);
            case "sorcerer":
                return new Sorcerer(name);
            case "paladin":
                return new Paladin(name);
            default:
                throw new IllegalArgumentException("Invalid hero type: " + type);
        }
    }
}