package LOGIC;

import GUI.Tile;

import java.util.Iterator;
import java.util.Stack;

public class MovesStack extends Stack {

    public void add(int index, Tile element) {
        super.add(index, element);
    }

    public boolean contains(Tile t) {
        Iterator<Tile> iter = this.iterator();

        while (iter.hasNext()){
            if(iter.next().getTableX() == t.getTableX() && iter.next().getTableY() == t.getTableY()){
                return true;
            }
        }
        return false;
    }
}
