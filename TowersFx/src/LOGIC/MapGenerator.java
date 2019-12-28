package LOGIC;

import GUI.Tile;

public class MapGenerator {

    public int[][] generateMap(int width, int height){

        int [][] map = emptyMap(width,height);

        return map;
    }

    public Tile[][] generateTileMap(int width, int height){

        Tile [][] tileMap = emptyTileMap(width,height);

        return  tileMap;
    }


    private int[][] emptyMap(int w, int h){
        int map[][]= new int[w][h];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                map[j][i] = 0;
            }
        }

        return map;
    }

    private Tile[][] emptyTileMap(int w, int h){
        Tile map[][]= new Tile[w][h];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                map[j][i] = new Tile();
            }
        }

        return map;
    }

    public int[][] easyMap(){

        // 5 columns
        int map[][] =
                {
                        {1,2,3,4},
                        {8,7,6,5},
                        {9,10,11,12},
                        {16,15,14,13},
                        {17,18,19,20},
                };
        return map;
    }

}
