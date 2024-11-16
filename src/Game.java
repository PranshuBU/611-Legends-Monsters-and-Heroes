/*
 * Game.java
 * This class manages the core gameplay loop, including the initialization of heroes,
 * handling of player inputs, and interactions with the game world such as movement,
 * market access, and battles. It coordinates hero actions, monitors for battles
 * or market encounters, and manages the progression of the game until it concludes.
 */


import Characters.Heroes.Hero;
import Characters.Monsters.Monster;
import Factory.*;
import Spaces.Position;
import MarketArea.Market;
import Exception.InputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private World world;
    private List<Hero> heroes;
    private boolean isWorking;
    private InputHandler<Integer> intHandler;
    private InputHandler<String> stringHandler;
    private CharacterFactory heroFactory;
    private CharacterFactory monsterFactory;

    public Game() {
        world = new World(8, 8); // 8x8 grid
        heroes = new ArrayList<>();
        isWorking = false;

        // Initialize input handlers
        intHandler = new InputHandler<>(Integer.class);
        stringHandler = new InputHandler<>(String.class);

        heroFactory = new HeroFactory();
        monsterFactory = new MonsterFactory();
    }

    public void start() {
        isWorking = true;
        initializeHeroes();
        while (isWorking) {
            renderWorld();
            handlePlayerInput();
            lookforBattleorMarket();
        }
    }

    private void initializeHeroes() {
        // Get party size with validation
        int partySize = intHandler.getInput(
                "Number of heroes in your team? (choose between 1-3): ",
                1, 3
        );

        for (int i = 0; i < partySize; i++) {
            // Get hero name with non-empty validation
            String name = stringHandler.getInput(
                    "Enter hero's name: ",
                    input -> !input.trim().isEmpty(),
                    "Name cannot be empty"
            );

            Hero hero = null;
            while (hero == null) {
                String type = stringHandler.getStringInputIgnoreCase(
                        "Choose hero type (Warrior/Sorcerer/Paladin): ",
                        "warrior", "sorcerer", "paladin"
                );

                try {
                    hero = ((HeroFactory) heroFactory).createSpecificHero(name, type);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid type. Please try again.");
                }
            }

            Position startPosition = world.findValidStartPosition();
            hero.move(startPosition);
            heroes.add(hero);
        }
    }

    private void renderWorld() {
        world.renderWithHeroes(heroes);
    }

    private void handlePlayerInput() {
        String input = stringHandler.getStringInputIgnoreCase(
                "Enter move (W/A/S/D) or options (I/M/Q): ",
                "w", "a", "s", "d", "i", "m", "q"
        ).toUpperCase();

        switch (input) {
            case "W":
            case "A":
            case "S":
            case "D":
                PerformMovementsHeroes(input);
                break;
            case "I":
                displayHeroInfo();
                break;
            case "M":
                enterMarket();
                break;
            case "Q":
                isWorking = false;
                break;
        }
    }

    private void PerformMovementsHeroes(String direction) {
        int dx = 0, dy = 0;
        switch (direction) {
            case "W": dy = -1; break;
            case "S": dy = 1; break;
            case "A": dx = -1; break;
            case "D": dx = 1; break;
        }

        boolean validMove = true;
        for (Hero hero : heroes) {
            Position newPos = new Position(hero.getPosition().x + dx, hero.getPosition().y + dy);
            if (!world.isValidMove(newPos)) {
                validMove = false;
                break;
            }
        }

        if (validMove) {
            for (Hero hero : heroes) {
                Position newPos = new Position(hero.getPosition().x + dx, hero.getPosition().y + dy);
                hero.move(newPos);
                System.out.println(hero.getName() + " moved " + direction);
            }
        } else {
            System.out.println("Cannot move in that direction.");
        }
    }

    private void displayHeroInfo() {
        for (Hero hero : heroes) {
            System.out.println(hero.getInfo());
        }
    }

    private void enterMarket() {
        if (world.isMarketSpace(heroes.get(0).getPosition())) {
            Market market = new Market();
            for (Hero hero : heroes) {
                market.enterMarket(hero);
            }
        } else {
            System.out.println("No market here. Move to a market space to enter the market.");
        }
    }

    private void lookforBattleorMarket() {
        if (world.isCommonSpace(heroes.get(0).getPosition())) {
            if (new Random().nextDouble() < 0.2) { // 20% chance of battle
                beginBattle();
            }
        }
    }

    private void beginBattle() {
        List<Monster> monsters = generateMonsters();
        Battle battle = new Battle(heroes, monsters);
        battle.startBattle();
        if (battle.isHeroesWon()) {
            giveRewards();
        } else {
            gameOver();
        }
    }

    private List<Monster> generateMonsters() {
        List<Monster> monsters = new ArrayList<>();
        int highestHeroLevel = heroes.stream().mapToInt(Hero::getLevel).max().orElse(1);
        for (int i = 0; i < heroes.size(); i++) {
            Monster monster = (Monster) monsterFactory.createCharacter("Monster " + (i + 1), highestHeroLevel);
            monsters.add(monster);
        }
        return monsters;
    }

    private void giveRewards() {
        int totalExperience = heroes.size() * 2;
        int totalGold = 0;
        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                hero.gainExperience(totalExperience);
                int goldGain = hero.getLevel() * 100;
                hero.gainGold(goldGain);
                totalGold += goldGain;
            }
        }
        System.out.println("Heroes gained " + totalExperience + " experience and " + totalGold + " gold!");
    }

    private void gameOver() {
        System.out.println("Game Over! All heroes have been defeated.");
        isWorking = false;
    }
}