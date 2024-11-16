/*

 **CharacterFactory**:
  An interface that defines a factory for creating game characters. It includes a single method, `createCharacter`, which takes a name and level as parameters and returns an instance of a `GameCharacter`. This interface allows for flexibility in creating different character types, such as heroes or monsters, by implementing specific factory classes.
 */

package Factory;

import Characters.GameCharacter;

public interface CharacterFactory {
    GameCharacter createCharacter(String name, int level);
}