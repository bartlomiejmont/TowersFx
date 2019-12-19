package LOGIC;

import GUI.Tile;

import java.util.Stack;

public class MainLogic {

    private Tile lastTile;
    private Stack moves = new Stack();

    private int[][] map;

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }
}
