/*
 * World.java
 * This class represents the game world as a grid of spaces, which may include
 * inaccessible areas, markets, and common spaces. It generates a randomized map layout,
 * provides methods to display the grid, and tracks hero positions. It also handles
 * validations for movements within the grid and determines specific space types
 * such as market or common space for game interactions.
 */


import Characters.Heroes.Hero;
import Spaces.*;

import java.util.List;
import java.util.Random;

public class World {
    private Space[][] grid;
    private int width;
    private int height;
    private Random random;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Space[height][width];
        this.random = new Random();
        generateWorld();
    }

    public Position findValidStartPosition() {
        while (true) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            if (isValidMove(x, y)) {
                return new Position(x, y);
            }
        }
    }

    private void generateWorld() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double chance = random.nextDouble();
                if (chance < 0.2) {
                    grid[i][j] = new InaccessibleSpace();
                } else if (chance < 0.5) {
                    grid[i][j] = new MarketSpace();
                } else {
                    grid[i][j] = new CommonSpace();
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public void renderWithHeroes(List<Hero> heroes) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean heroPresent = false;
                for (int i = 0; i < heroes.size(); i++) {
                    Hero hero = heroes.get(i);
                    if (hero.getPosition().x == x && hero.getPosition().y == y) {
//                        System.out.print("H" + (i+1) + " ");
                        System.out.print(hero.getName().substring(0, 2).toUpperCase() + " ");
                        heroPresent = true;
                        break;
                    }
                }
                if (!heroPresent) {
                    System.out.print(grid[y][x].getSymbol() + "  ");
                }
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height && grid[y][x].isAccessible();
    }



    public boolean isValidMove(Position pos) {
        return pos.x >= 0 && pos.x < width && pos.y >= 0 && pos.y < height && grid[pos.y][pos.x].isAccessible();
    }


    public boolean isMarketSpace(Position pos) {
        return grid[pos.y][pos.x] instanceof MarketSpace;
    }

    public boolean isCommonSpace(Position pos) {
        return grid[pos.y][pos.x] instanceof CommonSpace;
    }

    public Space getSpace(int x, int y) {
        if (isValidMove(x, y)) {
            return grid[y][x];
        }
        return null;
    }




    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}