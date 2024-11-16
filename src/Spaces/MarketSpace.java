/*

MarketSpace.java
Represents a market space in the game where heroes can access a marketplace.
When a hero enters, it prompts the player to enter the market.
The class provides methods to display the market symbol, retrieve the market,
and allow a hero to interact with the market for buying and selling items.
 */

package Spaces;


import Characters.Heroes.Hero;
import MarketArea.Market;

public class MarketSpace extends Space {
    private Market market;

    public MarketSpace() {
        super(true, true);
        this.market = new Market();
    }

    @Override
    public String getSymbol() {
        return "M";
    }

    @Override
    public void onEnter(Hero hero) {
        System.out.println("This is a Market space. Press 'M' to go to the market.");
    }

    public Market getMarket() {
        return market;
    }

    public void enterMarket(Hero hero) {
        System.out.println("Welcome to the market, " + hero.getName() + "!");
        market.enterMarket(hero);
    }
}