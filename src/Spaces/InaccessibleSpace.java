/*

 InaccessibleSpace.java
 Represents an inaccessible space in the game where heroes cannot enter.
  When a hero attempts to enter, it displays an error message indicating that entry is not allowed.
  This class provides a symbol to represent inaccessible spaces in the game grid.
 */

package Spaces;


import Characters.Heroes.Hero;

public class InaccessibleSpace extends Space {
    public InaccessibleSpace() {
        super(false, false);
    }

    @Override
    public String getSymbol() {
        return "X";
    }

    @Override
    public void onEnter(Hero hero) {
        System.out.println("Error: Cannot enter an inaccessible space!");
    }
}