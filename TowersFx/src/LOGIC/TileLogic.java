package LOGIC;

import GUI.SceneGenerator;
import GUI.Tile;

import java.util.Stack;

public class TileLogic {

    SceneGenerator sceneGenerator = new SceneGenerator();

    public void move(Tile tile){

        if(isMovePossible(tile)){
            makeMove(tile);
        }

        else if(isRevertPossible(tile)){
            revertMove();
        }

        if(MainLogic.moves.size()==MainLogic.width*MainLogic.height){
            sceneGenerator.gameOverScene();
        }
    }


    public boolean isMovePossible(Tile tile){

        if(MainLogic.lastTile==null&&!tile.isRed()){
//            System.out.println("first move");
            return true;
        }
        else if(MainLogic.lastTile==null){
            return false;
        }

        System.out.println("tile: " + tile + " allPosibleMoves: " + allPassibleMoves() + " lastTile: " + MainLogic.lastTile + " contains: " + allPassibleMoves().contains(tile));

        if(MainLogic.moves.contains(tile)){
//            System.out.println("Tile already visited");
            return false;
        }
        else  if(allPassibleMoves().contains(tile)&&MainLogic.fuel>0){
//            System.out.println("Move is posible");
            if(tile.isRed()&&MainLogic.fuel!=1){
                System.out.println("fuel != 1");
                return false;
            }
//            System.out.println("moving" + tile);
            return true;
        }
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

//        for(Tile t: possibleMoves){
//            System.out.println(t.tileInfo());
//        }

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
            if(MainLogic.lastTile.isRed()){
                MainLogic.fuel=1;
            }
            else {
                MainLogic.fuel++;
            }
            MainLogic.moves.pop();
            MainLogic.lastTile = (Tile) MainLogic.moves.lastElement();
        }
        else {
            MainLogic.moves.pop();
            MainLogic.lastTile = null;
            MainLogic.fuel = 5;
        }
    }

    private void makeMove(Tile tile){
        System.out.println("JD");
        MainLogic.moves.push(tile);
        MainLogic.lastTile = tile;
        if(tile.isRed()){
            MainLogic.fuel=5;
        }
        else{
            MainLogic.fuel--;
        }
    }
}
