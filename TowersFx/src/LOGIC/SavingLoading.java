package LOGIC;

import GUI.Tile;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class SavingLoading {

    public void saveGame()
    {
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
                MainLogic.moves = (Stack<Tile>) save.get("moves");
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
        Stage stage = (Stage) MainLogic.primaryWindow;
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("c:\\"));


        File file = chooser.showOpenDialog(stage);

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject employeeList = (JSONObject) obj;
            System.out.println(MainLogic.moves);
            //System.out.println(employeeList.get("moves"));


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
