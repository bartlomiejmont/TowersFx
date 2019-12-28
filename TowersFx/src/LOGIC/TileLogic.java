package LOGIC;

import GUI.Main;
import GUI.Tile;

import java.util.Stack;

public class TileLogic {

    public void move(Tile tile){

        if(isMovePossible(tile)){
            MainLogic.moves.push(tile);
            MainLogic.lastTile = tile;
        }

        else if(isRevertPossible(tile)){
            revertMove();
        }
    }


    public boolean isMovePossible(Tile tile){

        if(MainLogic.lastTile==null){
            return true;
        }

        if(MainLogic.moves.contains(tile)){
            System.out.println("False");
            return false;
        }
        else  if(allPassibleMoves().contains(tile)){
            System.out.println("True");
            return true;
        }

        System.out.println("False");
        return false;
    }

    private Stack<Tile> allPassibleMoves(){

        Stack<Tile> possibleMoves = new Stack<Tile>();
            // top
        if(MainLogic.lastTile.getTableX()>=0 && MainLogic.lastTile.getTableX()<=MainLogic.width-1 && MainLogic.lastTile.getTableY()+1>=0 && MainLogic.lastTile.getTableY()+1<=MainLogic.height-1 && !MainLogic.moves.contains(MainLogic.tileMap[MainLogic.lastTile.getTableX()][MainLogic.lastTile.getTableY()+1])){
            possibleMoves.push(MainLogic.tileMap[MainLogic.lastTile.getTableX()][MainLogic.lastTile.getTableY()+1]);
        }
            // bottom
        if(MainLogic.lastTile.getTableX()>=0 && MainLogic.lastTile.getTableX()<=MainLogic.width-1 && MainLogic.lastTile.getTableY()-1>=0 && MainLogic.lastTile.getTableY()-1<=MainLogic.height-1 && !MainLogic.moves.contains(MainLogic.tileMap[MainLogic.lastTile.getTableX()][MainLogic.lastTile.getTableY()-1])){
            possibleMoves.push(MainLogic.tileMap[MainLogic.lastTile.getTableX()][MainLogic.lastTile.getTableY()-1]);
        }
            // right
        if(MainLogic.lastTile.getTableX()+1>=0 && MainLogic.lastTile.getTableX()+1<=MainLogic.width-1 && MainLogic.lastTile.getTableY()>=0 && MainLogic.lastTile.getTableY()<=MainLogic.height-1 && !MainLogic.moves.contains(MainLogic.tileMap[MainLogic.lastTile.getTableX()+1][MainLogic.lastTile.getTableY()])){
            possibleMoves.push(MainLogic.tileMap[MainLogic.lastTile.getTableX()+1][MainLogic.lastTile.getTableY()]);
        }
            // left
        if(MainLogic.lastTile.getTableX()-1>=0 && MainLogic.lastTile.getTableX()-1<=MainLogic.width-1 && MainLogic.lastTile.getTableY()>=0 && MainLogic.lastTile.getTableY()<=MainLogic.height-1 && !MainLogic.moves.contains(MainLogic.tileMap[MainLogic.lastTile.getTableX()-1][MainLogic.lastTile.getTableY()])){
            possibleMoves.push(MainLogic.tileMap[MainLogic.lastTile.getTableX()-1][MainLogic.lastTile.getTableY()]);
        }

        for(Tile t: possibleMoves){
            System.out.println(t.tileInfo());
        }

        return possibleMoves;
    }

    public boolean isRevertPossible(Tile tile){

        if(MainLogic.lastTile == tile){
            return true;
        }
        return false;
    }

    private void revertMove(){
        if(MainLogic.moves.size()>1){
            MainLogic.moves.pop();
            MainLogic.lastTile = MainLogic.moves.lastElement();
        }
        else {
            MainLogic.moves.pop();
            MainLogic.lastTile = null;
        }
    }
}
