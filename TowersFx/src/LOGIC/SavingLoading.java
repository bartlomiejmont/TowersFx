package LOGIC;

import GUI.SceneGenerator;
import GUI.Tile;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SavingLoading {

    public void saveGame()
    {
        SceneGenerator sceneGenerator = new SceneGenerator();
        Stage stage = (Stage) MainLogic.primaryWindow;
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("c:\\"));
        chooser.setInitialFileName("save.json");

        File file = chooser.showSaveDialog(stage);

        if (file != null)
        {
            try
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                List <Integer> map = new ArrayList<>();

                for(int y=0 ; y < MainLogic.height; y++){
                    for(int x=0; x < MainLogic.width; x++){
                        map.add(MainLogic.map[x][y]);
                    }
                }

                JSONArray list = new JSONArray();

                JSONObject save = new JSONObject();

                save.put("lastTile", MainLogic.lastTile);
                save.put("moves", MainLogic.moves);
                save.put("map",map);
                save.put("width", MainLogic.width);
                save.put("height", MainLogic.height);
                save.put("fuel", MainLogic.fuel);

//                MainLogic.moves = (Stack<Tile>) save.get("moves");
//                System.out.println(MainLogic.moves);

                list.add("Hello World");

                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(save.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void loadGame(){
        SceneGenerator sceneGenerator = new SceneGenerator();
        MapGenerator mapGenerator = new MapGenerator();
        Stage stage = (Stage) MainLogic.primaryWindow;
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("c:\\"));
        File file = chooser.showOpenDialog(stage);

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject save = (JSONObject) obj;

            JSONObject lastTileJSON = (JSONObject) save.get("lastTile");
            JSONArray mapJSON = (JSONArray) save.get("map");
            Object widthObj = JSONValue.parse(save.get("width").toString());
            Object heightObj = JSONValue.parse(save.get("height").toString());
            Object fuelObj = JSONValue.parse(save.get("fuel").toString());

            Map lastTile =  lastTileJSON;

            int y = (int)(long) lastTile.get("tableY");
            int x = (int)(long) lastTile.get("tableX");
            MainLogic.width = (int)(long) widthObj;
            MainLogic.height = (int)(long) heightObj;
            MainLogic.fuel =(int)(long) fuelObj;

            int mapIndex = 0;
            int map[][]= new int[MainLogic.width][MainLogic.height];

            for(int i=0; i<MainLogic.height; i++){
                for(int j=0; j<MainLogic.width; j++){
                    map[j][i] = (int)(long)mapJSON.get(mapIndex);
                    mapIndex++;
                }
            }
            MainLogic.map = map;

            MainLogic.lastTile = new Tile((x+y) % 2 == 0,y,x);
            MainLogic.tileMap = mapGenerator.generateTileMap(MainLogic.width,MainLogic.height);

            stage.setScene(sceneGenerator.makeScene(MainLogic.width,MainLogic.height));
            MainLogic.getTileMap(MainLogic.width,MainLogic.height);

            System.out.println(mapJSON);
            System.out.println(MainLogic.lastTile);



        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
