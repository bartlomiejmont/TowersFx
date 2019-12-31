package LOGIC;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;


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

                JSONArray list = new JSONArray();

                list.add("Hello World");

                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(list.toJSONString());
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

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
