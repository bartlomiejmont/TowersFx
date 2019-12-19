package LOGIC;

public class MapGenerator {

    public int[][] generateMap(int width, int height){

        int [][] map = emptyMap(width,height);


        return map;
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

    public int[][] easyMap(){

        int map[][] =
                {
                        {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                };
        return map;
    }

}
