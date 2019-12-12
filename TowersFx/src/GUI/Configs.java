package GUI;

public class Configs {
    private static Configs ourInstance = new Configs();

    public static Configs getInstance() {
        return ourInstance;
    }

    int TILE_SIZE = 80;
    int EASY_HEIGHT = 4;
    int MEDIUM_HEIGHT = 5;
    int HARD_HEIGHT = 6;
    int EASY_WIDTH = 5;
    int MEDIUM_WIDTH = 6;
    int HARD_WIDTH = 7;

    private Configs() {

    }
}
