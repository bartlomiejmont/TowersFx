package LOGIC;

import GUI.Tile;

import java.util.Stack;

public class CreateModeTileLogic extends TileLogic {

    public CreateModeTileLogic() {
        MainLogic.tileNumber=1;
    }

    @Override
    public boolean isRevertPossible(Tile tile) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void move(Tile tile) {
        if(isMovePossible(tile)){
            makeMove(tile);
        }
    }

    @Override
    public boolean isMovePossible(Tile tile) {

        if(MainLogic.lastTile==null){
            return true;
        }
        else if(allPassibleMoves().contains(tile)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Stack<Tile> allPassibleMoves() {
        return super.allPassibleMoves();
    }

    private void makeMove (Tile tile){
        MainLogic.lastTile = tile;
        MainLogic.map[tile.getTableX()][tile.getTableY()] = MainLogic.tileNumber;

        for(int i=0; i<MainLogic.height; i++){
            for(int j=0; j<MainLogic.width; j++){
                System.out.println(MainLogic.map[j][i]);
            }
        }
        MainLogic.tileNumber++;
    }

}

