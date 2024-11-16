/*
Position.java
 Represents a coordinate in the game grid with `x` and `y` values to define a location.
This class is used to track and manage the position of characters and other entities within the game world.
 */

package Spaces;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}