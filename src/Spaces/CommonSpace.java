/*
CommonSpace.java
 Represents a common space in the game where battles can occur with a 20% probability.
 When a hero enters, it may trigger a battle, indicated by the `hasBattle` attribute.
 The class provides methods to check if a battle is active, reset the battle state, and display the symbol for common spaces.

 */
package Spaces;


import Characters.Heroes.Hero;
import Characters.GameCharacter;

public class CommonSpace extends Space {
    private boolean hasBattle;

    public CommonSpace() {
        super(true, false);
        this.hasBattle = false;
    }

    @Override
    public String getSymbol() {
        return "C";
    }

    @Override
    public void onEnter(Hero hero) {
        // Battle Chance
        if (Math.random() < 0.2) { // 20% chance of battle
            hasBattle = true;
            System.out.println("Battle has begun!");

        } else {
            System.out.println("There is no battle going on now in the common space!");
        }
    }

    public boolean hasBattle() {
        return hasBattle;
    }

    public void resetBattle() {
        hasBattle = false;
    }
}