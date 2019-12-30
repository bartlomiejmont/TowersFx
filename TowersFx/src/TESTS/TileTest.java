package TESTS;

import GUI.Tile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TileTest {

    Tile tile;

    @Before
    public void init(){
        tile = new Tile(true,2,2);
    }

    @Test
    public void makeTileRed(){
        tile.setRed(true);
        Assert.assertTrue(tile.isRed());
    }


}
