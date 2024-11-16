/*
Space.java
An abstract class that represents a space within the game world,
 characterized by whether it is accessible and whether it contains a market.
 The class provides abstract methods for retrieving the space's symbol and defining behavior
 when a hero enters the space. Specific types of spaces, like MarketSpace and CommonSpace,
 extend this class with specialized behaviors.
 */

package Spaces;

import Characters.Heroes.Hero;

public abstract class Space {
    protected boolean isAccessible;
    protected boolean hasMarket;

    public Space(boolean isAccessible, boolean hasMarket) {
        this.isAccessible = isAccessible;
        this.hasMarket = hasMarket;
    }

    public boolean isAccessible() {
        return isAccessible;
    }


    public abstract String getSymbol();

    public abstract void onEnter(Hero hero);
}
