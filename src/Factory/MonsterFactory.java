/*
 * MonsterFactory.java
 * This factory class is responsible for creating various types of monsters for the game.
 * It implements the CharacterFactory interface and provides methods to generate random
 * monsters or create specific monster types, such as Dragon, Exoskeleton, and Spirit, based on inputs.
 * The class includes a method to create a random monster and another to create a monster of a specified type.
 */


package Factory;

import Characters.GameCharacter;
import Characters.Monsters.*;

import java.util.Random;

public class MonsterFactory implements CharacterFactory {
    @Override
    public GameCharacter createCharacter(String name, int level) {
        Random rand = new Random();
        int type = rand.nextInt(3);
        Monster monster;

        switch (type) {
            case 0:
                monster = new Dragon(name, level);
                break;
            case 1:
                monster = new Exoskeleton(name, level);
                break;
            case 2:
                monster = new Spirit(name, level);
                break;
            default:
                monster = new Spirit(name, level);
        }

        return monster;
    }

    public Monster createSpecificMonster(String name, String type, int level) {
        switch (type.toLowerCase()) {
            case "dragon":
                return new Dragon(name, level);
            case "exoskeleton":
                return new Exoskeleton(name, level);
            case "spirit":
                return new Spirit(name, level);
            default:
                throw new IllegalArgumentException("Invalid monster type: " + type);
        }
    }
}