package GUI;

public class Configs {
    private static Configs ourInstance = new Configs();

    public static Configs getInstance() {
        return ourInstance;
    }

    public final int TILE_SIZE = 80;
    public final int EASY_HEIGHT = 4;
    public final int MEDIUM_HEIGHT = 5;
    public final int HARD_HEIGHT = 6;
    public final int EASY_WIDTH = 5;
    public final int MEDIUM_WIDTH = 6;
    public final int HARD_WIDTH = 7;

    private Configs() {

    }
}
