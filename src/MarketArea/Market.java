/*
 * Market.java
 * This class represents a market where heroes can buy and sell items.
 * It generates a random selection of items for sale and allows heroes to interact
 * with the market to purchase or sell equipment such as weapons, armor, potions, and spells.
 * The class includes methods to display available items, handle transactions, and
 * validate hero inventory and gold for purchases.
 */


package MarketArea;
import Characters.Heroes.Hero;
import Items.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Exception.InputHandler;
public class Market {
    private List<Item> items;
    private Random random;
    private InputHandler<Integer> inputHandler;

    public Market() {
        items = new ArrayList<>();
        random = new Random();
        generateItems();
        inputHandler = new InputHandler<>(Integer.class);
    }

    private void generateItems() {
        int displaySize = 10 + random.nextInt(10);
        for (int i = 0; i < 10; i++) {
            items.add(new Weapon("Sword" + i, 120 + random.nextInt(1000), 1 + random.nextInt(20), 15 + random.nextInt(100), 1));
            items.add(new Armor("Shield" + i, 70 + random.nextInt(1000), 1 + random.nextInt(20), 10 + random.nextInt(100)));
            items.add(new Potion("Health Potion" + i, 50 + random.nextInt(1000), 1 + random.nextInt(20), 50 + random.nextInt(100)));
            items.add(new Spell("Flame Thrower" + i, 150 + random.nextInt(1000), 1 + random.nextInt(20), 20 + random.nextInt(100), 50 + random.nextInt(200), "Fire"));
            items.add(new Spell("Ice Beam" + i, 150 + random.nextInt(1000), 1 + random.nextInt(20), 20 + random.nextInt(100), 50 + random.nextInt(200), "ice"));
        }
    }

    public void enterMarket(Hero hero) {
        boolean inMarket = true;

        while (inMarket) {
            System.out.println("\nWelcome to the market, " + hero.getName() + "!");
            System.out.println("Your gold: " + hero.getGold());
            System.out.println("1. Buy item");
            System.out.println("2. Sell item");
            System.out.println("3. Exit market");

            int choice = inputHandler.getInput("Choose an option: ", 1, 3);

            switch (choice) {
                case 1:
                    buyItem(hero);
                    break;
                case 2:
                    sellItem(hero);
                    break;
                case 3:
                    inMarket = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void buyItem(Hero hero) {
        System.out.println("\nItems for sale:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }

        int choice = inputHandler.getInput("Enter the number of the item you want to buy (0 to cancel): ", 0, items.size());

        if (choice > 0) {
            Item item = items.get(choice - 1);
            if (hero.canBuyItem(item)) {
                hero.buyItem(item);
                items.remove(item);
                System.out.println("You bought: " + item);
            } else {
                System.out.println("You can't afford this item or your level is too low.");
            }
        }
    }

    private void sellItem(Hero hero) {
        List<Item> inventory = hero.getInventory();
        System.out.println("\nYour inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }

        int choice = inputHandler.getInput("Enter the number of the item you want to sell (0 to cancel): ", 0, inventory.size());

        if (choice > 0) {
            Item item = inventory.get(choice - 1);
            hero.sellItem(item);
            items.add(item);
            System.out.println("You sold: " + item);
        }
    }
}